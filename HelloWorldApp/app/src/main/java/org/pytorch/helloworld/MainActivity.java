package org.pytorch.helloworld;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.pytorch.IValue;
import org.pytorch.LiteModuleLoader;
import org.pytorch.Module;
import org.pytorch.Tensor;
import org.pytorch.torchvision.TensorImageUtils;
import org.pytorch.MemoryFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  private Button btn_takephoto;
  private ImageView imageView;
  private TextView textView;
  public static final int TAKE_PHOTO = 1;
  private Module module = null;
  private Bitmap bitmap = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
  }

  private void init() {
    btn_takephoto = (Button) findViewById(R.id.button1);
    imageView = (ImageView) findViewById(R.id.image);
    textView = (TextView) findViewById(R.id.text1);
    btn_takephoto.setOnClickListener(new View.OnClickListener() {
      @Override
      @Deprecated
      public void onClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, TAKE_PHOTO);
      }
    });

    try {
//            bitmap = BitmapFactory.decodeStream(getAssets().open("image.jpg"));
      module = LiteModuleLoader.load(assetFilePath(this, "model.ptl"));
    } catch (IOException e) {
      Log.e("PytorchHelloWorld", "Error reading assets", e);
      finish();
    }


  }



  @SuppressLint("SetTextI18n")
  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK){
      if (requestCode == TAKE_PHOTO){//可以判断是我们那个Intent发出的请求
        assert data != null;
        Bundle bundle = data.getExtras();//在相机这个应用中包含的是整个二进制流
        bitmap = (Bitmap) bundle.get("data");
        imageView.setImageBitmap(bitmap);

        final Tensor inputTensor = TensorImageUtils.bitmapToFloat32Tensor(bitmap,
                TensorImageUtils.TORCHVISION_NORM_MEAN_RGB, TensorImageUtils.TORCHVISION_NORM_STD_RGB, MemoryFormat.CHANNELS_LAST);

        final Tensor outputTensor = module.forward(IValue.from(inputTensor)).toTensor();

        final float[] scores = outputTensor.getDataAsFloatArray();

        float maxScore = -Float.MAX_VALUE;
        int maxScoreIdx = -1;
        for (int i = 0; i < scores.length; i++) {
          if (scores[i] > maxScore) {
            maxScore = scores[i];
            maxScoreIdx = i;
          }
        }
//        String className = ImageNetClasses.IMAGENET_CLASSES[maxScoreIdx];
        String className = DogCatClasses.IMAGENET_CLASSES[maxScoreIdx];
        textView.setText(className);
      }
    }
  }

  public static String assetFilePath(Context context, String assetName) throws IOException {
    File file = new File(context.getFilesDir(), assetName);
    if (file.exists() && file.length() > 0) {
      return file.getAbsolutePath();
    }

    try (InputStream is = context.getAssets().open(assetName)) {
      try (OutputStream os = new FileOutputStream(file)) {
        byte[] buffer = new byte[4 * 1024];
        int read;
        while ((read = is.read(buffer)) != -1) {
          os.write(buffer, 0, read);
        }
        os.flush();
      }
      return file.getAbsolutePath();
    }
  }

}
