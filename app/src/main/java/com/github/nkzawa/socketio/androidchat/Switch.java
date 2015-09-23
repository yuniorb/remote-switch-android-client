package com.github.nkzawa.socketio.androidchat;

import java.util.Date;

public class Switch  {

    private String mId;
    private String mName;
    private Date mStatusDate;
    private boolean mStatus;

    private Switch() {}

    public String getId(){
        return mId;
    }

    public String getName() {
        return mName;
    }

    public boolean getStatus() {
        return mStatus;
    }

    public Date getStatusDate() {
        return mStatusDate;
    }

    public static class Builder {
        private String mId;
        private String mName;
        private Date mStatusDate;
        private boolean mStatus;

        public Builder id(String id)
        {
            mId = id;
            return this;
        }

        public Builder name(String name) {
            mName = name;
            return this;
        }
        public Builder status(boolean status) {
            mStatus = status;
            return this;
        }

        public Builder status_date(Date status_date) {
            mStatusDate = status_date;
            return this;
        }

        public Switch build() {
            Switch message = new Switch();
            message.mId = mId;
            message.mName = mName;
            message.mStatus = mStatus;
            message.mStatusDate = mStatusDate;
            return message;
        }
    }


    public boolean equals(Object obj)
    {
        if(obj != null)
        {
            String id = ((Switch) obj).getId();
            if(id == null )
            {
                if(mId == null) return true;
                return false;
            }
            return id.compareTo(this.getId()) == 0;
        }
        return false;
    }
}
