package com.github.nkzawa.socketio.androidchat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class SwitchAdapter extends RecyclerView.Adapter<SwitchAdapter.ViewHolder> {

    private List<Switch> mSwitches;

    public SwitchAdapter(Context context, List<Switch> switches) {
        mSwitches = switches;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = -1;
        switch (viewType) {
            case Message.TYPE_MESSAGE:
                layout = R.layout.item_message;
                break;
            case Message.TYPE_LOG:
                layout = R.layout.item_log;
                break;
            case Message.TYPE_ACTION:
                layout = R.layout.item_action;
                break;
        }
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Switch aSwitch = mSwitches.get(position);
        viewHolder.setName(aSwitch.getName());
        viewHolder.setStatus(aSwitch.getStatus());
        viewHolder.setStatusDate(aSwitch.getStatusDate());
    }

    @Override
    public int getItemCount() {
        return mSwitches.size();
    }

    @Override
    public int getItemViewType(int position) {
       // return mSwitches.get(position).getType();
        int value = 0;
        return value;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private android.widget.Switch mStatus;
        private TextView mStatusDate;

        public ViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.message);
            mStatus = (android.widget.Switch) itemView.findViewById(R.id.switch1);
            mStatusDate = (TextView) itemView.findViewById(R.id.switch_time);
        }

        public void setName(String name) {
            if (null == mName) return;
            mName.setText(name);
        }

        public void setStatus(boolean status) {
            if (null == mStatus) return;
            mStatus.setChecked(status);
        }

        public void setStatusDate(Date status_date) {
            if (null == mName) return;
            DateFormat timeFormat = DateFormat.getTimeInstance();
            mStatusDate.setText(timeFormat.format(status_date));
        }
    }
}
