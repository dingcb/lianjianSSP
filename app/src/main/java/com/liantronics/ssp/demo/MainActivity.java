package com.liantronics.ssp.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import liantronics.sspsdk.AdListener;
import liantronics.sspsdk.AdManager;

public class MainActivity extends Activity {
    String tag="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //顶部横幅
        showTopBannerAd(((EditText) findViewById(R.id.et1)).getText().toString().trim());
        //底部横幅
        showBottomBannerAd(((EditText)findViewById(R.id.et2)).getText().toString().trim());
        //插屏
        showInterstitialAd(((EditText)findViewById(R.id.et3)).getText().toString().trim());
        //开屏
        showSplashAd(((EditText)findViewById(R.id.et5)).getText().toString().trim());
        //底部横幅视频
        showBottomBannerAdVideo(((EditText)findViewById(R.id.et6)).getText().toString().trim());
        //嵌入式广告
        showEmbedAd(((EditText)findViewById(R.id.et7)).getText().toString().trim());
        //嵌入式视频
        showEmbedAdVideo(((EditText)findViewById(R.id.et8)).getText().toString().trim());

        //关闭所有广告
        findViewById(R.id.bt4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.clear();
            }
        });
        //关闭顶部横幅
        findViewById(R.id.bt9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.closeAd(tag);
            }
        });
    }

    /**
     * 嵌入式视频
     * @param positionId 广告位ID
     */
    private void showEmbedAdVideo(final String positionId) {
        findViewById(R.id.bt8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdManager.showEmbedAd(MainActivity.this, positionId,R.id.fl2, new AdListener() {
                            @Override
                            public void onAdPresent() {
                            }

                            @Override
                            public void onAdClick() {
                            }

                            @Override
                            public void onAdDismissed() {
                            }

                            @Override
                            public void onAdFailed(int code) {
                                Toast.makeText(MainActivity.this,"错误码："+code,Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 嵌入式广告
     * @param positionId 广告位ID
     */
    private void showEmbedAd(final String positionId) {
        findViewById(R.id.bt7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.showEmbedAd(MainActivity.this,positionId,R.id.fl, new AdListener() {
                            @Override
                            public void onAdPresent() {
                            }

                            @Override
                            public void onAdClick() {
                            }

                            @Override
                            public void onAdDismissed() {
                            }

                            @Override
                            public void onAdFailed(int code) {
                                Toast.makeText(MainActivity.this,"错误码："+code,Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 底部横幅视频
     * @param positionId 广告位ID
     */
    private void showBottomBannerAdVideo(final String positionId) {
        findViewById(R.id.bt6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.showBottomBannerAd(MainActivity.this,positionId, new AdListener() {
                            @Override
                            public void onAdPresent() {
                            }

                            @Override
                            public void onAdClick() {
                            }

                            @Override
                            public void onAdDismissed() {
                            }

                            @Override
                            public void onAdFailed(int code) {
                                Toast.makeText(MainActivity.this,"错误码："+code,Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 开屏
     * @param positionId 广告位ID
     */
    private void showSplashAd(final String positionId) {
        findViewById(R.id.bt5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.showSplashAd(MainActivity.this,positionId, 3,new AdListener() {
                            @Override
                            public void onAdPresent() {
                            }

                            @Override
                            public void onAdClick() {
                            }

                            @Override
                            public void onAdDismissed() {
                            }

                            @Override
                            public void onAdFailed(int code) {
                                Toast.makeText(MainActivity.this,"错误码："+code,Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 插屏
     * @param positionId 广告位ID
     */
    private void showInterstitialAd(final String positionId) {
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdManager.showInterstitialAd(MainActivity.this,positionId, new AdListener() {
                            @Override
                            public void onAdPresent() {
                            }

                            @Override
                            public void onAdClick() {
                            }

                            @Override
                            public void onAdDismissed() {
                            }

                            @Override
                            public void onAdFailed(int code) {
                                Toast.makeText(MainActivity.this,"错误码："+code,Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 底部横幅
     *  @param positionId 广告位ID
     */
    private void showBottomBannerAd(final String positionId) {
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.showBottomBannerAd(MainActivity.this,positionId, 100, new AdListener() {
                            @Override
                            public void onAdPresent() {
                            }

                            @Override
                            public void onAdClick() {
                            }

                            @Override
                            public void onAdDismissed() {
                            }

                            @Override
                            public void onAdFailed(int code) {
                                Toast.makeText(MainActivity.this,"错误码："+code,Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 顶部横幅
     * @param positionId 广告位ID
     */
    private void showTopBannerAd(final String positionId) {
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag= AdManager.showTopBannerAd(MainActivity.this,positionId, 100, new AdListener() {
                            @Override
                            public void onAdPresent() {
                            }

                            @Override
                            public void onAdClick() {
                            }

                            @Override
                            public void onAdDismissed() {
                            }

                            @Override
                            public void onAdFailed(int code) {
                                Toast.makeText(MainActivity.this,"错误码："+code,Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
