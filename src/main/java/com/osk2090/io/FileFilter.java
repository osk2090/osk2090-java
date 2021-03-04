package com.osk2090.io;

import java.io.File;

public interface FileFilter {
    boolean accept(File pathname);
}