package com.system.pojo;

import java.io.Serializable;

//人员流量
public class PersonFlow implements Serializable {
    private Integer id;

    private String canteen;

    private String bath;

    private String library;

    private String studyRoom;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCanteen() {
        return canteen;
    }

    public void setCanteen(String canteen) {
        this.canteen = canteen == null ? null : canteen.trim();
    }

    public String getBath() {
        return bath;
    }

    public void setBath(String bath) {
        this.bath = bath == null ? null : bath.trim();
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library == null ? null : library.trim();
    }

    public String getStudyRoom() {
        return studyRoom;
    }

    public void setStudyRoom(String studyRoom) {
        this.studyRoom = studyRoom == null ? null : studyRoom.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", canteen=").append(canteen);
        sb.append(", bath=").append(bath);
        sb.append(", library=").append(library);
        sb.append(", studyRoom=").append(studyRoom);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}