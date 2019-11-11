package com.example.admin.myapplication.Activity;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myapplication.MainActivity;
import com.example.admin.myapplication.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.DIRECTORY_PICTURES;
import static android.os.Environment.getExternalStoragePublicDirectory;

public class RegisterActivity extends AppCompatActivity {

//    InputValidation inputValidation;
//    DatabaseHelper databaseHelper;
    NestedScrollView nestedScrollView;
    int GALLERY = 2, CAMERA = 1;
//    DBHelper db;

    EditText EdRegisterCode;
    //    TextInputLayout InputLayoutCode;
    Button BtnRegister;
    ImageView ImgRegisProfile;
    TextView ErrorCodeMsg;

    private final int PICK_IMAGE = 12345;
    private final int TAKE_PICTURE = 6352;
    private static final int REQUEST_CAMERA_ACCESS_PERMISSION =5674;
    private Bitmap bitmap;

    File file;
    Uri uri;
    String pathFile;
    Intent CamIntent, GalIntent, CropIntent ;
    public  static final int RequestPermissionCode  = 1 ;
    DisplayMetrics displayMetrics ;
    int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EdRegisterCode = findViewById(R.id.etRegisCode);
        BtnRegister = findViewById(R.id.BtnRegister);

        if(Build.VERSION.SDK_INT>=23){
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},2);
        }
        ImgRegisProfile = findViewById(R.id.ImgRegisProfile);
        ErrorCodeMsg = findViewById(R.id.TxtErrorMsg);
//        InputLayoutCode=findViewById(R.id.InputRegisCode);
        nestedScrollView = findViewById(R.id.RegidScrollView);



//        EnableRuntimePermission();




        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = EdRegisterCode.getText().toString();
                //use sqliteDBHelper
//                int id= checkRegis(new User(code));
//                if(id==-1)
//                {
//                    Toast.makeText(RegisterActivity.this,"User Does Not Exist",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(RegisterActivity.this,"User Exist ",Toast.LENGTH_SHORT).show();
//                }
                if(code.equals("abcdefgh")){
                    Intent i=new Intent(RegisterActivity.this, ChangePassword.class);
                    startActivity(i);
                }else{
                    Intent i=new Intent(RegisterActivity.this, RegisterActivity.class);
                    startActivity(i);
                }

            }
//                int id= checkRegisUser(new User(code));
//                if(id==-1)
//                {
//                    Toast.makeText(RegisterActivity.this,"User Does Not Exist",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(RegisterActivity.this,"User Exist "+code,Toast.LENGTH_SHORT).show();
//                }

//                    verifyFromSQLite();

//                if (EdRegisterCode.getText().toString().trim().isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "please write your code..", Toast.LENGTH_SHORT).show();
//                }
//                else if (code.equals("abcdefgh")) {
//                    Toast.makeText(getApplicationContext(), "successfully", Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
//                    startActivity(i);
//                } else if (code != "abcdefgh") {
//                    Toast.makeText(getApplicationContext(), "wrong code..", Toast.LENGTH_SHORT).show();
//                }


//

        });

//        db=new DBHelper(RegisterActivity.this);
////inserting dummy users
//        db.addUser(new User("Ankur", "hh@gmail.com","hh123","abcdefgh"));
//        db.addUser(new User("harvi", "hv@gmail.com","hv123","hdfcefee"));
//        db.addUser(new User("Ankur", "hh@gmail.com","hh123","vvvvvvvv"));



        ImgRegisProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                GetImageFromGallery();
                showPictureDialog();
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_PICK);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
//                }
            }
        });

    }

//    public int checkRegis(User user)
//    {
//        return db.checkRegis(user);
//    }
//

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this,
                Manifest.permission.CAMERA))
        {

            Toast.makeText(RegisterActivity.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(RegisterActivity.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }
    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(RegisterActivity.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(RegisterActivity.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }

    public void GetImageFromGallery(){

        GalIntent = new Intent(Intent.ACTION_PICK ,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(Intent.createChooser(GalIntent, "Select Image From Gallery"), 2);


    }

    private void takePhotoFromCamera() {
        Intent takePic=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePic.resolveActivity(getPackageManager())!=null){
            File photofile=null;
            photofile=createPhotoFile();

            if(photofile!=null)
            {
                pathFile= photofile.getAbsolutePath();
                Uri uriPhoto= FileProvider.getUriForFile(RegisterActivity.this,"com.example.chandan.curvedlayout",photofile);
                takePic.putExtra(MediaStore.EXTRA_OUTPUT,uriPhoto);
                startActivityForResult(takePic,3);
            }
        }
//



    }

    private File createPhotoFile() {
        String name=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File PicDirectory=getExternalStoragePublicDirectory(DIRECTORY_PICTURES);
        File image=null;
        try{
            image=File.createTempFile(name,".jpg",PicDirectory);

        }catch (Exception e){
            Log.d("mylog","Excep"+e.toString());
        }
        return image;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {

            ImageCropFunction();

        }
        else if (requestCode == 2) {

            if (data != null) {

                uri = data.getData();

                ImageCropFunction();

            }
        }else if(requestCode==3){
            Bitmap bitmap= BitmapFactory.decodeFile(pathFile);
            ImgRegisProfile.setImageBitmap(bitmap);
        }
        else if (requestCode == 1) {

            if (data != null) {

                Bundle bundle = data.getExtras();

                Bitmap bitmap = bundle.getParcelable("data");

                ImgRegisProfile.setImageBitmap(bitmap);

            }
        }
    }

    public void ImageCropFunction() {

        // Image Crop Code
        try {
            CropIntent = new Intent("com.android.camera.action.CROP");

            CropIntent.setDataAndType(uri, "image/*");

            CropIntent.putExtra("crop", "true");
            CropIntent.putExtra("outputX", 180);
            CropIntent.putExtra("outputY", 180);
            CropIntent.putExtra("aspectX", 3);
            CropIntent.putExtra("aspectY", 3);
            CropIntent.putExtra("scaleUpIfNeeded", true);
            CropIntent.putExtra("return-data", true);

            startActivityForResult(CropIntent, 1);

        } catch (ActivityNotFoundException e) {

        }
    }
    //Image Crop Code End Here

    //check register code

//    private void verifyFromSQLite() {
//        if (!inputValidation.isInputEditTextFilled(EdRegisterCode, ErrorCodeMsg, "please enter code")) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextEmail(EdRegisterCode, ErrorCodeMsg, "error in code")) {
//            return;
//        }
//
//        if (databaseHelper.checkRegisUser(EdRegisterCode.getText().toString().trim())) {
//
//
//            Intent accountsIntent = new Intent(RegisterActivity.this, MainActivity.class);
//            accountsIntent.putExtra("EMAIL", EdRegisterCode.getText().toString().trim());
////            emptyInputEditText();
//            EdRegisterCode.setText(null);
//            startActivity(accountsIntent);
//
//
//        } else {
//            // Snack Bar to show success message that record is wrong
//            Snackbar.make(nestedScrollView, "Wrong code", Snackbar.LENGTH_LONG).show();
//        }
//    }

    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                GetImageFromGallery();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }




}

