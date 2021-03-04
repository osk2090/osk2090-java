package com.osk2090.f;

public class Canvas {
    Pen tool;

    public Canvas(Pen tool) {
        this.tool = tool;
    }

    public void setPen(Pen tool) {
        this.tool = tool;
    }

    public void render(String contents) {
        tool.write(contents);
    }
}