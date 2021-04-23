package com.osk2090.mybatis.vo;

public class AttachFile {
    int fileNo;
    String filePath;
    int boardNo;

    public AttachFile(String filePath, int boardNo) {
        this.filePath = filePath;
        this.boardNo = boardNo;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }
}