package com.josecuentas.jc_mvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jose Cuentas Turpo on 27/11/2015 - 11:48 AM.
 * E-mail: jcuentast@gmail.com
 */
public class User implements Parcelable {
    
    public int id;
    public String name;
    public String lastName;
    public String user;
    public String password;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.lastName);
        dest.writeString(this.user);
        dest.writeString(this.password);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.lastName = in.readString();
        this.user = in.readString();
        this.password = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
