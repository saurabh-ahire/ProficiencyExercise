package saurabh.test.com.proficiencyexercise.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("canadaInformations")
    @Expose
    private List<CanadaInformation> canadaInformations = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CanadaInformation> getCanadaInformations() {
        return canadaInformations;
    }

    public void setCanadaInformations(List<CanadaInformation> canadaInformations) {
        this.canadaInformations = canadaInformations;
    }
}
