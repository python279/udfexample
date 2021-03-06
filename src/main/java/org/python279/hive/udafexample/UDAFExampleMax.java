package org.python279.hive.udafexample;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.serde2.io.DoubleWritable;
import org.apache.hadoop.hive.serde2.io.ShortWritable;
import org.apache.hadoop.hive.shims.ShimLoader;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

@Description(name = "example_max", value = "_FUNC_(expr) - Returns the maximum value of expr")
public class UDAFExampleMax extends UDAF {

    static public class MaxShortEvaluator implements UDAFEvaluator {
        private short mMax;
        private boolean mEmpty;

        public MaxShortEvaluator() {
            super();
            init();
        }

        public void init() {
            mMax = 0;
            mEmpty = true;
        }

        public boolean iterate(ShortWritable o) {
            if (o != null) {
                if (mEmpty) {
                    mMax = o.get();
                    mEmpty = false;
                } else {
                    mMax = (short) Math.max(mMax, o.get());
                }
            }
            return true;
        }

        public ShortWritable terminatePartial() {
            return mEmpty ? null : new ShortWritable(mMax);
        }

        public boolean merge(ShortWritable o) {
            return iterate(o);
        }

        public ShortWritable terminate() {
            return mEmpty ? null : new ShortWritable(mMax);
        }
    }

    static public class MaxIntEvaluator implements UDAFEvaluator {
        private int mMax;
        private boolean mEmpty;

        public MaxIntEvaluator() {
            super();
            init();
        }

        public void init() {
            mMax = 0;
            mEmpty = true;
        }

        public boolean iterate(IntWritable o) {
            if (o != null) {
                if (mEmpty) {
                    mMax = o.get();
                    mEmpty = false;
                } else {
                    mMax = Math.max(mMax, o.get());
                }
            }
            return true;
        }

        public IntWritable terminatePartial() {
            return mEmpty ? null : new IntWritable(mMax);
        }

        public boolean merge(IntWritable o) {
            return iterate(o);
        }

        public IntWritable terminate() {
            return mEmpty ? null : new IntWritable(mMax);
        }
    }

    static public class MaxLongEvaluator implements UDAFEvaluator {
        private long mMax;
        private boolean mEmpty;

        public MaxLongEvaluator() {
            super();
            init();
        }

        public void init() {
            mMax = 0;
            mEmpty = true;
        }

        public boolean iterate(LongWritable o) {
            if (o != null) {
                if (mEmpty) {
                    mMax = o.get();
                    mEmpty = false;
                } else {
                    mMax = Math.max(mMax, o.get());
                }
            }
            return true;
        }

        public LongWritable terminatePartial() {
            return mEmpty ? null : new LongWritable(mMax);
        }

        public boolean merge(LongWritable o) {
            return iterate(o);
        }

        public LongWritable terminate() {
            return mEmpty ? null : new LongWritable(mMax);
        }
    }

    static public class MaxFloatEvaluator implements UDAFEvaluator {
        private float mMax;
        private boolean mEmpty;

        public MaxFloatEvaluator() {
            super();
            init();
        }

        public void init() {
            mMax = 0;
            mEmpty = true;
        }

        public boolean iterate(FloatWritable o) {
            if (o != null) {
                if (mEmpty) {
                    mMax = o.get();
                    mEmpty = false;
                } else {
                    mMax = Math.max(mMax, o.get());
                }
            }
            return true;
        }

        public FloatWritable terminatePartial() {
            return mEmpty ? null : new FloatWritable(mMax);
        }

        public boolean merge(FloatWritable o) {
            return iterate(o);
        }

        public FloatWritable terminate() {
            return mEmpty ? null : new FloatWritable(mMax);
        }
    }

    static public class MaxDoubleEvaluator implements UDAFEvaluator {
        private double mMax;
        private boolean mEmpty;

        public MaxDoubleEvaluator() {
            super();
            init();
        }

        public void init() {
            mMax = 0;
            mEmpty = true;
        }

        public boolean iterate(DoubleWritable o) {
            if (o != null) {
                if (mEmpty) {
                    mMax = o.get();
                    mEmpty = false;
                } else {
                    mMax = Math.max(mMax, o.get());
                }
            }
            return true;
        }

        public DoubleWritable terminatePartial() {
            return mEmpty ? null : new DoubleWritable(mMax);
        }

        public boolean merge(DoubleWritable o) {
            return iterate(o);
        }

        public DoubleWritable terminate() {
            return mEmpty ? null : new DoubleWritable(mMax);
        }
    }

    static public class MaxStringEvaluator implements UDAFEvaluator {
        private Text mMax;
        private boolean mEmpty;

        public MaxStringEvaluator() {
            super();
            init();
        }

        public void init() {
            mMax = null;
            mEmpty = true;
        }

        public boolean iterate(Text o) {
            if (o != null) {
                if (mEmpty) {
                    mMax = new Text(o);
                    mEmpty = false;
                } else if (mMax.compareTo(o) < 0) {
                    mMax.set(o);
                }
            }
            return true;
        }

        public Text terminatePartial() {
            return mEmpty ? null : mMax;
        }

        public boolean merge(Text o) {
            return iterate(o);
        }

        public Text terminate() {
            return mEmpty ? null : mMax;
        }
    }
}

