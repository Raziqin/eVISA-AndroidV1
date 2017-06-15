package com.example.uksbraziq.latlong;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.android.gms.vision.barcode.Barcode;

public class appdetail extends AppCompatActivity {

    String appNo;
    ImageView QRImage;
    TextView tv;

    Bitmap bitmap;

    public final static int QRWidth = 500;
    MultiFormatWriter writer = new MultiFormatWriter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appdetail);

        tv= (TextView) findViewById(R.id.tv_appNo);
        QRImage = (ImageView) findViewById(R.id.image);


        appNo = getIntent().getStringExtra(String.valueOf(profile.KEY_APPNO));

        tv.setText(getIntent().getStringExtra(String.valueOf(profile.KEY_APPNO)));

        System.out.println("App Number is " + appNo);

        try{
            bitmap = TextToImageEncode(appNo);
            QRImage.setImageBitmap(bitmap);
            System.out.println("bitmap is on !  ");

        }catch(Exception e){
            e.printStackTrace();

        }
    }

    Bitmap TextToImageEncode(String Value) throws WriterException{
        BitMatrix bitMatrix;

        try{
            bitMatrix = new MultiFormatWriter().encode(
                    Value, BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRWidth,QRWidth,null);

        }catch (IllegalArgumentException illegalargumentexception){
            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();
        int bitMatrixHeight = bitMatrix.getHeight();
        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];


        for(int y=0; y < bitMatrixHeight; y++){
            int offset = y * bitMatrixWidth;
            for(int x=0; x< bitMatrixWidth; x++) {
                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.QRBlack):
                        getResources().getColor(R.color.QRWhite);
            }

        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);
        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;

    }
}
