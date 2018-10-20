package com.example.dinesh.cfd;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ChatAppMsgAdapter extends RecyclerView.Adapter<ChatAppMsgViewHolder> {
    @NonNull

    private List<ChatAppMsg> msgDtoList = null;

    public ChatAppMsgAdapter(List<ChatAppMsg> msgDtoList){
        this.msgDtoList = msgDtoList;
    }
    @Override
    public ChatAppMsgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //Debug from here on by vchanging the main activity
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_chat_app_item_view,parent,false);
        return new ChatAppMsgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAppMsgViewHolder holder, int position) {

        ChatAppMsg msgDto = this.msgDtoList.get(position);

        if (msgDto.MSG_TYPE_RECEIVED.equals(msgDto.getMsgType())){
            holder.leftMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.leftMsgTextView.setText(msgDto.getMsgContent());
            holder.rightMsgLayout.setVisibility(LinearLayout.GONE);
        }
        else if (msgDto.MSG_TYPE_SENT.equals(msgDto.getMsgType())){
            holder.rightMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.rightMsgTextView.setText(msgDto.getMsgContent());
            holder.leftMsgLayout.setVisibility(LinearLayout.GONE);

        }


    }

    @Override
    public int getItemCount() {
        if (msgDtoList==null){
            msgDtoList = new ArrayList<ChatAppMsg>();
        }
        return msgDtoList.size();
    }
}
