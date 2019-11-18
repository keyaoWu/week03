package com.bawei.wukeyao20191118.glide;

import android.widget.ImageView;

import com.bawei.wukeyao20191118.R;
import com.bawei.wukeyao20191118.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/**
 * 功能：GlideHolder类
 * 作者：武柯耀
 * 当前日期：2019/11/18
 * 当前时间：10:25
 */
public class GlideHolder {
    public static void ImageHolder(String url, ImageView imageView){
        Glide.with(MyApp.mContext)
                .load(url)
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .priority(Priority.HIGH)
                .into(imageView);
    }
}
