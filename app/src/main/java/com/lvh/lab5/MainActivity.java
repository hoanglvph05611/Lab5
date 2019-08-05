package com.lvh.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;


import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.rockerhieu.emojicon.EmojiconEditText;
import com.lvh.lab5.adapter.ChatAdapter;
import com.lvh.lab5.model.Message;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Socket mSocket;

    {
        try {
            mSocket = IO.socket("https://socket-io-chat.now.sh");
        } catch (URISyntaxException e) {
        }
    }

    private RecyclerView lvList;

    private List<Message> chatList;

    private LinearLayoutManager linearLayoutManager;

    private ChatAdapter chatAdapter;

    private EmojiconEditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  getSupportActionBar().setTitle("Lê Hoàng");
        toolbar.setContentInsetStartWithNavigation(10);
        toolbar.setNavigationIcon(R.drawable.drawer);


        // toolbar.setSubtitle("last active: 10 sec ago");

        lvList = findViewById(R.id.mList);
        chatList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this);
        chatAdapter = new ChatAdapter(chatList, this);
        lvList.setAdapter(chatAdapter);
        lvList.setLayoutManager(linearLayoutManager);

        editText = findViewById(R.id.edMsg);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                Log.e("EVENT", keyEvent.getAction() + "");
                if (keyEvent.getAction() == 0) {
                    String message = editText.getText().toString();

                    Message chat = new Message();
                   // chat.name = "Huy Nguyen";
                    chat.msgMy = message;
                    chatList.add(chat);
                    chatAdapter.notifyDataSetChanged();

                    mSocket.emit("new message", message);
                    editText.setText("");

                    lvList.smoothScrollToPosition(chatList.size() - 1);
                }

                return false;
            }
        });

        mSocket.emit("add user", "LVH Coder");

        mSocket.on("new message", onNewMessage);
        mSocket.on("login", onLogin);
        mSocket.connect();
    }

    private Emitter.Listener onLogin = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];

                    int numUsers;
                    try {
                        numUsers = data.getInt("numUsers");
                        Toast.makeText(MainActivity.this, "Có " + numUsers + " trong phòng chat",
                                Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        return;
                    }

                }
            });

        }
    };
    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String username;
                    String message;
                    try {
                    //    username = data.getString("username");
                        message = data.getString("message");

                        Message chat = new Message();
                     //   chat.name = username;
                        chat.msgOther = message;
                        chatList.add(chat);
                        chatAdapter.notifyDataSetChanged();
                        lvList.smoothScrollToPosition(chatList.size() - 1);

                    } catch (JSONException e) {
                        return;
                    }

                    // add the message to view
                    //addMessage(username, message);
                }
            });
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
    }
}