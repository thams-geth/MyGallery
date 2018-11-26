package com.tts.mygallery;

import android.net.Uri;

import java.util.Date;

public class FilePOJO {

    private String fileName;
    private long lastEditDate;
    private Uri fileImage;

    public FilePOJO() {
    }

    public FilePOJO(String fileName, long lastEditDate, Uri fileImage) {
        this.fileName = fileName;
        this.lastEditDate = lastEditDate;
        this.fileImage = fileImage;
    }

    public long getLastEditDate() {

        return lastEditDate;
    }

    public void setLastEditDate(long lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getFileName()
    { return fileName; }

    public void setFileName(String fileName)
    { this.fileName =  fileName; }

    public void setFileImage(Uri fileImage)
    { this.fileImage = fileImage; }

    public Uri getFileImage()
    { return fileImage; }

}