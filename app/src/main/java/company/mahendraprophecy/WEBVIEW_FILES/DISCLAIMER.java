package company.mahendraprophecy.WEBVIEW_FILES;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.pnikosis.materialishprogress.ProgressWheel;

import company.mahendraprophecy.R;

public class DISCLAIMER extends ActionBarActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disclaimer);

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("www.mahendraprophecy.com")
                .appendPath("api")
                .appendPath("v1")
                .appendPath("page.php")
                .appendQueryParameter("q", "disclaimer")
                .appendQueryParameter("key", "1c0d2809e0140c09c6003d098400d477");

        String Url = builder.build().toString();
        webView = (WebView) findViewById(R.id.disclaimer);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(Url);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                ((ProgressWheel)findViewById(R.id.disclaimer_progress_wheel)).setVisibility(View.INVISIBLE);
            }
        });

        ((ImageButton) findViewById(R.id.disclaimer_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
