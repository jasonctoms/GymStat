package com.apps.straightface.gymstat.Data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class GymStatContract
{
    public static final String CONTENT_AUTHORITY = "com.apps.straightface.gymstat";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_EXERCISE = "exercise";
    public static final String PATH_ROUTINE = "routine";
    public static final String PATH_STATS = "stats";

    /* Inner class that defines the table contents of the exercise table */
    public static final class ExerciseEntry implements BaseColumns
    {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_EXERCISE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EXERCISE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EXERCISE;

        // Table name
        public static final String TABLE_NAME = "exercise";

        // This will be the name of each exercise
        public static final String COLUMN_EXERCISE_NAME = "exercise_name";

        // This will be the muscle group(s)
        public static final String COLUMN_MUSCLE_GROUP = "muscle_group";

        //This will be the Uri that points to the image of the exercise
        public static final String COLUMN_EXERCISE_IMAGE = "exercise_image";


        public static Uri buildExerciseUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    /* Inner class that defines the table contents of the routine table */
    public static final class RoutineEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ROUTINE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ROUTINE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ROUTINE;

        public static final String TABLE_NAME = "routine";

        // Column with the foreign keys into the exercise table.
        public static final String COLUMN_EX_KEYS = "exercise_keys";

        // The name of the routine
        public static final String COLUMN_ROUTINE_NAME = "routine_name";

        // Days that the routine will be done on
        public static final String COLUMN_DAYS = "days";

        // Number of sets for the given exercise ID
        public static final String COLUMN_NUM_SETS = "num_sets";

        public static Uri buildRoutineUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    /* Inner class that defines the table contents of the stats table */
    public static final class StatsEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_STATS).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STATS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STATS;

        public static final String TABLE_NAME = "stats";

        // Column with the foreign key into the exercise table.
        public static final String COLUMN_EX_KEY = "exercise_key";

        // Column with the foreign key into the routine table
        public static final String COLUMN_ROUTINE_KEY = "routine_key";

        // The date that the exercise was logged into the table
        public static final String COLUMN_DATE = "date";

        // The weight amount for an entry
        public static final String COLUMN_WEIGHT = "weight";

        // The set number for an entry
        public static final String COLUMN_SET_NUM = "set_num";

        // The unit used for this entry
        public static final String COLUMN_UNIT = "unit";

        // 0 or 1 to show if this is the best set for a given exercise
        public static final String COLUMN_BEST_SET = "best_set";

        // The total weight of the workout (last entry in db should be total weight)
        public static final String COLUMN_TOTAL_WEIGHT = "total_weight";

        // 0 or 1 to show if this is the best total for a given routine
        public static final String COLUMN_BEST_TOTAL = "best_total";


        public static Uri buildStatsUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
