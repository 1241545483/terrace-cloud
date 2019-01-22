package com.synapse.reading.dto.result;

import com.synapse.reading.model.Directories;

public class DirectoriesResult {
    private Directories directories = new Directories();
    private  String oneLevelName;
    private  String twoLevelName;
    private  String thereLevelName;
    private  String Name;
    private  String recId;
    private  String publishStatus;

    public DirectoriesResult(){}
    public DirectoriesResult(Directories  directories){
        this.directories = directories;
    }


    public Directories getModel() {
        return directories;
    }

    public void setModel(Directories directories) {
        this.directories = directories;
    }

    public String getOneLevelName() {
        return oneLevelName;
    }

    public void setOneLevelName(String oneLevelName) {
        this.oneLevelName = oneLevelName;
    }

    public String getTwoLevelName() {
        return twoLevelName;
    }

    public void setTwoLevelName(String twoLevelName) {
        this.twoLevelName = twoLevelName;
    }

    public String getThereLevelName() {
        return thereLevelName;
    }

    public void setThereLevelName(String thereLevelName) {
        this.thereLevelName = thereLevelName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }
}
