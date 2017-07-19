package com.beauty.youvideo.Utils;

import android.util.Log;

/**
 * Created by bangwen.lei on 2017/7/18.
 */

public class BLog {
    private static boolean DEBUG = true;
    public static String TAG = "YouVideoLog";

    public static void i(String msg) {
        if (!DEBUG) {
            return;
        }
        Log.i(TAG, "[" + getRunInfo() + "]" + msg);
    }

    public static void i(String tag, String msg) {
        if (!DEBUG) {
            return;
        }
        Log.i(tag, "[" + getRunInfo() + "]" + msg);
    }

    public static void e(String msg) {
        if (!DEBUG) {
            return;
        }
        Log.e(TAG, "[" + getRunInfo() + "]" + msg);
    }

    public static void e(String tag, String msg) {
        if (!DEBUG) {
            return;
        }
        Log.e(tag, "[" + getRunInfo() + "]" + msg);
    }

    public static void w(String msg) {
        if (!DEBUG) {
            return;
        }
        Log.w(TAG, "[" + getRunInfo() + "]" + msg);
    }

    public static void w(String tag, String msg) {
        if (!DEBUG) {
            return;
        }
        Log.w(tag, "[" + getRunInfo() + "]" + msg);
    }

    public static void d(String msg) {
        if (!DEBUG) {
            return;
        }
        Log.d(TAG, "[" + getRunInfo() + "]" + msg);
    }

    public static void d(String tag, String msg) {
        if (!DEBUG) {
            return;
        }
        Log.d(tag, "[" + getRunInfo() + "]" + msg);
    }

    public static void v(String msg) {
        if (!DEBUG) {
            return;
        }
        Log.v(TAG, "[" + getRunInfo() + "]" + msg);
    }

    public static void v(String tag, String msg) {
        if (!DEBUG) {
            return;
        }
        Log.v(tag, "[" + getRunInfo() + "]" + msg);
    }

    public static String getRunInfo() {
        StringBuffer toStringBuffer = null;
        try {
            StackTraceElement traceElement = ((new Exception()).getStackTrace())[3];
            StackTraceElement traceElement2 = ((new Exception())
                    .getStackTrace())[4];
            toStringBuffer = new StringBuffer(""
                    + Thread.currentThread().getId()).append(" | ")
                    .append(traceElement.getFileName()).append(" | ")
                    .append(traceElement.getLineNumber()).append(" | ")
                    .append(traceElement2.getMethodName()).append(" -> ")
                    .append(traceElement.getMethodName()).append("()");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toStringBuffer != null ? toStringBuffer.toString() : null;
    }
}
