package com.liantronics.ssp.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import liantronics.sspsdk.AdListener;
import liantronics.sspsdk.AdManager;

public class MainActivity extends Activity {
    String tag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //顶部横幅
        showTopBannerAd();
        //底部横幅
        showBottomBannerAd();
        //插屏
        showInterstitialAd();
        //开屏
        showSplashAd();

        //信息流
        showEmbedInfoAd();
        //视频广告
        showEmbedVideoAd();

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
     * 视频广告
     */
    private void showEmbedVideoAd() {
        findViewById(R.id.bt8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.showEmbedVideoAd(MainActivity.this,
                        ((EditText) findViewById(R.id.et8)).getText().toString().trim(),//广告位ID
                        R.id.fl2, new AdListener() {
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
                                Toast.makeText(MainActivity.this, "错误码：" + code, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 信息流广告
     */
    private void showEmbedInfoAd() {
        findViewById(R.id.bt7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.showEmbedInfoAd(MainActivity.this,
                        ((EditText) findViewById(R.id.et7)).getText().toString().trim(),//广告位ID
                        R.id.fl1, new AdListener() {
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
                                Toast.makeText(MainActivity.this, "错误码：" + code, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }


    /**
     * 开屏
     */
    private void showSplashAd() {
        findViewById(R.id.bt5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.showSplashAd(MainActivity.this,
                        ((EditText) findViewById(R.id.et5)).getText().toString().trim(), //广告位ID
                        3, new AdListener() {
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
                                Toast.makeText(MainActivity.this, "错误码：" + code, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 插屏
     */
    private void showInterstitialAd() {
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdManager.showInterstitialAd(MainActivity.this,
                        ((EditText) findViewById(R.id.et3)).getText().toString().trim(), //广告位ID
                        new AdListener() {
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
                                Toast.makeText(MainActivity.this, "错误码：" + code, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 底部横幅
     */
    private void showBottomBannerAd() {
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdManager.showBottomBannerAd(MainActivity.this,
                        ((EditText) findViewById(R.id.et2)).getText().toString().trim(),//广告位ID
                        100, new AdListener() {
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
                                Toast.makeText(MainActivity.this, "错误码：" + code, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     * 顶部横幅
     */
    private void showTopBannerAd() {
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = AdManager.showTopBannerAd(MainActivity.this,
                        ((EditText) findViewById(R.id.et1)).getText().toString().trim(),//广告位ID
                        100, new AdListener() {
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
                                Toast.makeText(MainActivity.this, "错误码：" + code, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
