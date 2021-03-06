package org.achartengine.renderer;

import android.graphics.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.chart.PointStyle;

public class XYSeriesRenderer extends SimpleSeriesRenderer {
    private List<FillOutsideLine> mFillBelowLine;
    private boolean mFillPoints;
    private float mLineWidth;
    private float mPointStrokeWidth;
    private PointStyle mPointStyle;

    public static class FillOutsideLine implements Serializable {
        private int mColor;
        private int[] mFillRange;
        private final Type mType;

        public enum Type {
            NONE,
            BOUNDS_ALL,
            BOUNDS_BELOW,
            BOUNDS_ABOVE,
            BELOW,
            ABOVE
        }

        public FillOutsideLine(Type type) {
            this.mColor = Color.argb(125, 0, 0, 200);
            this.mType = type;
        }

        public int getColor() {
            return this.mColor;
        }

        public void setColor(int color) {
            this.mColor = color;
        }

        public Type getType() {
            return this.mType;
        }

        public int[] getFillRange() {
            return this.mFillRange;
        }

        public void setFillRange(int[] range) {
            this.mFillRange = range;
        }
    }

    public XYSeriesRenderer() {
        this.mFillPoints = false;
        this.mFillBelowLine = new ArrayList();
        this.mPointStyle = PointStyle.POINT;
        this.mPointStrokeWidth = 1.0f;
        this.mLineWidth = 1.0f;
    }

    @Deprecated
    public boolean isFillBelowLine() {
        return this.mFillBelowLine.size() > 0;
    }

    @Deprecated
    public void setFillBelowLine(boolean fill) {
        this.mFillBelowLine.clear();
        if (fill) {
            this.mFillBelowLine.add(new FillOutsideLine(Type.BOUNDS_ALL));
        } else {
            this.mFillBelowLine.add(new FillOutsideLine(Type.NONE));
        }
    }

    public FillOutsideLine[] getFillOutsideLine() {
        return (FillOutsideLine[]) this.mFillBelowLine.toArray(new FillOutsideLine[0]);
    }

    public void addFillOutsideLine(FillOutsideLine fill) {
        this.mFillBelowLine.add(fill);
    }

    public boolean isFillPoints() {
        return this.mFillPoints;
    }

    public void setFillPoints(boolean fill) {
        this.mFillPoints = fill;
    }

    @Deprecated
    public void setFillBelowLineColor(int color) {
        if (this.mFillBelowLine.size() > 0) {
            ((FillOutsideLine) this.mFillBelowLine.get(0)).setColor(color);
        }
    }

    public PointStyle getPointStyle() {
        return this.mPointStyle;
    }

    public void setPointStyle(PointStyle style) {
        this.mPointStyle = style;
    }

    public float getPointStrokeWidth() {
        return this.mPointStrokeWidth;
    }

    public void setPointStrokeWidth(float strokeWidth) {
        this.mPointStrokeWidth = strokeWidth;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.mLineWidth = lineWidth;
    }
}
