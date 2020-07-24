package py.com.thundersoda.samplestudio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class Main2Activity extends Activity {

    private RelativeLayout imgContainer, layoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgContainer = (RelativeLayout) findViewById(R.id.img_container);
        layoutContainer = (RelativeLayout) findViewById(R.id.layout_container);

        findViewById(R.id.button1).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
                        //Obtener la altura de img_container
                        int imgContainerHeight = imgContainer.getHeight();
                        //Valor de margen superior
                        int marginTop = 50;
                        imgContainerHeight += marginTop;
                        //Obtener la altura del frameLayout padre
                        int frameLayoutHeight = frameLayout.getHeight();

                        //Establecer la nueva altura para layout_container
                        ViewGroup.LayoutParams layoutContainerParams = layoutContainer.getLayoutParams();
                        layoutContainerParams.height = frameLayoutHeight - imgContainerHeight;
                        layoutContainer.setLayoutParams(layoutContainerParams);
                    }
                });
    }
}