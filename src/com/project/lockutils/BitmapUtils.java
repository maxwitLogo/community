package com.project.lockutils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Environment;

public class BitmapUtils {

	/**
	 * 缩放图片
	 * 
	 * @param bitmap
	 * @param f
	 * @return
	 */
	public static Bitmap zoom(Bitmap bitmap, float zf) {
		Matrix matrix = new Matrix();
		matrix.postScale(zf, zf);
		return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
				bitmap.getHeight(), matrix, true);
	}

	public static boolean saveBitmap2file(Bitmap bmp, String filename) {
		CompressFormat format = Bitmap.CompressFormat.JPEG;
		int quality = 100;
		OutputStream stream = null;
		try {
			stream = new FileOutputStream("/"
					+ Environment.getExternalStorageDirectory() + "/"
					+ filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return bmp.compress(format, quality, stream);
	}

//	// // 缩放图片
//	public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {
//		// 获得图片的宽高
//		int width = bm.getWidth();
//		int height = bm.getHeight();
//		// 计算缩放比例
//		float scaleWidth = ((float) newWidth) / width;
//		float scaleHeight = ((float) newHeight) / height;
//		// 取得想要缩放的matrix参数
//		Matrix matrix = new Matrix();
//		matrix.postScale(scaleWidth, scaleHeight);
//		// 得到新的图片
//		Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix,
//				true);
//		return newbm;
//	}

	/** 从给定路径加载图片 */
	public static Bitmap loadBitmap(String imgpath, int w, int h) {
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;
		// 这里是整个方法的关键，inJustDecodeBounds设为true时将不为图片分配内存。
		BitmapFactory.decodeFile(imgpath, opts);
		int srcWidth = opts.outWidth;// 获取图片的原始宽度
		int srcHeight = opts.outHeight;// 获取图片原始高度
		int destWidth = 0;
		int destHeight = 0;
		// 缩放的比例
		double ratio = 0.0;
		if (srcWidth < w || srcHeight < h) {
			ratio = 0.0;
			destWidth = srcWidth;
			destHeight = srcHeight;
		} else if (srcWidth > srcHeight) {// 按比例计算缩放后的图片大小，maxLength是长或宽允许的最大长度
			ratio = (double) srcWidth / w;
			destWidth = w;
			destHeight = (int) (srcHeight / ratio);
		} else {
			ratio = (double) srcHeight / h;
			destHeight = h;
			destWidth = (int) (srcWidth / ratio);
		}
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		// 缩放的比例，缩放是很难按准备的比例进行缩放的，目前我只发现只能通过inSampleSize来进行缩放，其值表明缩放的倍数，SDK中建议其值是2的指数值
		newOpts.inSampleSize = (int) ratio + 1;
		// inJustDecodeBounds设为false表示把图片读进内存中
		newOpts.inJustDecodeBounds = false;
		// 设置大小，这个一般是不准确的，是以inSampleSize的为准，但是如果不设置却不能缩放
		newOpts.outHeight = destHeight;
		newOpts.outWidth = destWidth;

		Bitmap tempBitmap = BitmapFactory.decodeFile(imgpath, newOpts);
		int digree = 0;
		ExifInterface exif = null;
		try {
			exif = new ExifInterface(imgpath);
		} catch (IOException e) {
			e.printStackTrace();
			exif = null;
		}
		if (exif != null) {
			int ori = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_UNDEFINED);
			// 计算旋转角度
			switch (ori) {
			case ExifInterface.ORIENTATION_ROTATE_90:
				digree = 90;
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				digree = 180;
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				digree = 270;
				break;
			default:
				digree = 0;
				break;
			}
		}
		if (digree != 0) {
			// 旋转图片
			Matrix m = new Matrix();
			m.postRotate(digree);
			tempBitmap = Bitmap.createBitmap(tempBitmap, 0, 0,
					tempBitmap.getWidth(), tempBitmap.getHeight(), m, true);
		}

		// 获取缩放后图片
		return tempBitmap;
	}

	/**
	 * 缩放图片
	 * 
	 * @param bitmap
	 * @param f
	 * @return
	 */
	public static Bitmap zoom(Bitmap bitmap, float wf, float hf) {
		Matrix matrix = new Matrix();
		matrix.postScale(wf, hf);
		return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
				bitmap.getHeight(), matrix, true);
	}

	/**
	 * 图片圆角处理
	 * 
	 * @param bitmap
	 * @param roundPX
	 * @return
	 */
	public static Bitmap getRCB(Bitmap bitmap, float roundPX) {
		// RCB means
		// Rounded
		// Corner Bitmap
		Bitmap dstbmp = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(dstbmp);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPX, roundPX, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return dstbmp;
	}

	/**
	 * 圆角的处理
	 * 
	 * @param bitmap
	 */
	public static Bitmap getRoundCornerImage(Bitmap bitmap) {

		Bitmap oldBitmap = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);// 创建一个原图
		Canvas canvas = new Canvas(oldBitmap);// 创建带有位图roundConcerImage的画布
		Paint paint = new Paint();// 创建画笔
		Rect rect = new Rect(0, 0, bitmap.getHeight(), bitmap.getHeight());// 创建一个和原始图片一样大小的矩形
		RectF rectf = new RectF(rect);
		paint.setAntiAlias(true);// 去锯齿
		canvas.drawRoundRect(rectf, 100, 100, paint);// 画一个和原始图片一样大小的圆角矩形
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN)); // 设置相交模式
		canvas.drawBitmap(bitmap, null, rect, paint); // 把图片画到矩形去
		return oldBitmap;
	}

	// 圆形
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
		final Rect rect;
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		if (bitmap.getWidth() > bitmap.getHeight()) {

			rect = new Rect(0, 0, bitmap.getHeight(), bitmap.getHeight());
		} else {
			rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getWidth());
		}
		final RectF rectF = new RectF(rect);
		final float roundPx = bitmap.getWidth() / 2;

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}
}
