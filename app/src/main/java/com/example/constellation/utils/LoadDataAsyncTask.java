package com.example.constellation.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class LoadDataAsyncTask extends AsyncTask<String,Void,String> {

    Context context;
    OnGetNetDataListener listener;
    ProgressDialog dialog;
    boolean isShowDialog = false;
    private void initDialog(){
        dialog = new ProgressDialog(context);
        dialog.setTitle("提示信息");
        dialog.setMessage("正在加载中......");
    }
    public LoadDataAsyncTask(Context context, OnGetNetDataListener listener,boolean isShowDialog) {
        this.context = context;
        this.listener = listener;
        this.isShowDialog = isShowDialog;
        initDialog();
    }

    public interface OnGetNetDataListener{
        public void onSuccess(String json);
    }

    //    运行在主线程当中，通常在此方法中进行控件的初始化
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (isShowDialog) {
            dialog.show();
        }
    }

    //    运行在子线程当中，可以在此处进行耗时操作等逻辑 （比如获取网络请求）
    @Override
    protected String doInBackground(String... params) {
        String json = HttpUtils.getJSONFromNet(params[0]);
        return json;
    }

    //    运行在主线程，可以在此处得到doInBackground返回的数据，在此处通常进行控件的更新
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (isShowDialog) {
            dialog.dismiss();
        }

        listener.onSuccess(s);
    }
}