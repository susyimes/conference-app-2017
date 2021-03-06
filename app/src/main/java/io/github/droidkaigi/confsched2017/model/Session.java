package io.github.droidkaigi.confsched2017.model;

import com.google.gson.annotations.SerializedName;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;

@Table
public class Session {

    public static final String LANG_EN_ID = "EN";

    public static final String LANG_JA_ID = "JA";

    @PrimaryKey(auto = false)
    @Column(indexed = true)
    @SerializedName("id")
    public int id;

    @Column(indexed = true)
    @SerializedName("title")
    public String title;

    @Column
    @Nullable
    @SerializedName("desc")
    public String desc;

    @Column(indexed = true)
    @Nullable
    @SerializedName("speaker")
    public Speaker speaker;

    @Column
    @SerializedName("stime")
    public Date stime;

    @Column
    @SerializedName("etime")
    public Date etime;

    @Column
    @SerializedName("duration_min")
    public int durationMin;

    @Column
    @SerializedName("type")
    public String type;

    @Column(indexed = true)
    @Nullable
    @SerializedName("topic")
    public Topic topic;

    @Column(indexed = true)
    @Nullable
    @SerializedName("room")
    public Room room;

    @Column
    @Nullable
    @SerializedName("lang")
    public String lang;

    @Column
    @Nullable
    @SerializedName("slide_url")
    public String slideUrl;

    @Column
    @Nullable
    @SerializedName("movie_url")
    public String movieUrl;

    @Column
    @Nullable
    @SerializedName("movie_dash_url")
    public String movieDashUrl;

    @Column
    @Nullable
    @SerializedName("share_url")
    public String shareUrl;

    private enum Type {
        CEREMONY, SESSION, BREAK;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public boolean isSession() {
        return isSameType(Type.SESSION);
    }

    public boolean isCeremony() {
        return isSameType(Type.CEREMONY);
    }

    public boolean isBreak() {
        return isSameType(Type.BREAK);
    }

    private boolean isSameType(@NonNull Type type) {
        return type.toString().equals(this.type);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Session && ((Session) o).id == id || super.equals(o);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
