package saurabh.test.com.proficiencyexercise.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import saurabh.test.com.proficiencyexercise.model.data.CanadaInformation;

public class ResponseData {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
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
