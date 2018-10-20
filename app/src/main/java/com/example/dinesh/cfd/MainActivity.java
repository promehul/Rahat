package com.example.dinesh.cfd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView msgRecyclerView = (RecyclerView)findViewById(R.id.chat_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(linearLayoutManager);

        final List<ChatAppMsg> msgDtoList = new ArrayList<ChatAppMsg>();
        ChatAppMsg msgDto = new ChatAppMsg(ChatAppMsg.MSG_TYPE_RECEIVED,"hello");
        msgDtoList.add(msgDto);

        final ChatAppMsgAdapter chatAppMsgAdapter = new ChatAppMsgAdapter(msgDtoList);
        msgRecyclerView.setAdapter(chatAppMsgAdapter);

        final EditText msgInputText = (EditText)findViewById(R.id.chat_input_msg);

        Button msgSendButton = (Button)findViewById(R.id.chat_send_msg);

        msgSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgContent = msgInputText.getText().toString();

                if (!TextUtils.isEmpty(msgContent)){
                    ChatAppMsg msgDto = new ChatAppMsg(ChatAppMsg.MSG_TYPE_SENT,msgContent);
                    msgDtoList.add(msgDto);

                    int newMsgPosition = msgDtoList.size() - 1;

                    chatAppMsgAdapter.notifyItemInserted(newMsgPosition);

                    msgRecyclerView.scrollToPosition(newMsgPosition);

                    msgInputText.setText("");

                }

            }
        });


    }
}
