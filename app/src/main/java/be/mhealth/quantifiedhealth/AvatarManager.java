package be.mhealth.quantifiedhealth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

public class AvatarManager
{
    private final static String[] FILE_NAMES = {
        "sunflowers_state1_b",
        "sunflowers_state2_b",
    };
    private final static int NUM_BITMAPS = FILE_NAMES.length;

    private static AvatarManager instance = null;
    private Bitmap[] bitmaps;
    private ImageView avatarView;
    private int bitmapIdx;

    private AvatarManager()
    {
        bitmapIdx = 0;
    }

    public static AvatarManager getInstance()
    {
        if(instance == null)
            instance = new AvatarManager();
        else
            instance.bitmapIdx = 1;
        return instance;
    }

    public void initialize(
        Context aCtx,
        ImageView aAvatarView)
    {
        avatarView = aAvatarView;

        bitmaps = new Bitmap[NUM_BITMAPS];
        for (int i = 0; i < NUM_BITMAPS; ++i)
            bitmaps[i] = BitmapFactory.decodeResource(aCtx.getResources(), aCtx.getResources().getIdentifier("drawable/" + FILE_NAMES[i], null, aCtx.getPackageName()));

        avatarView.setImageBitmap(bitmaps[bitmapIdx]);
    }
}
