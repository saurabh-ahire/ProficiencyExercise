package saurabh.test.com.proficiencyexercise.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CanadaInformation implements Parcelable {

    public static final Creator<CanadaInformation> CREATOR = new Creator<CanadaInformation>() {
        @Override
        public CanadaInformation createFromParcel(Parcel in) {
            return new CanadaInformation(in);
        }

        @Override
        public CanadaInformation[] newArray(int size) {
            return new CanadaInformation[size];
        }
    };
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageHref")
    @Expose
    private String imageHref;

    protected CanadaInformation(Parcel in) {
        title = in.readString();
        description = in.readString();
        imageHref = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageHref() {
        return imageHref;
    }

    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(imageHref);
    }
}
