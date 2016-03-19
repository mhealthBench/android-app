package be.mhealth.quantifiedhealth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

public class AvatarManager
{
    private final static int NUM_BITMAPS = 8;
    private final static String[] FILE_NAMES = {
        "panda_01_crying",
        "panda_12_scared",
        "panda_02_really_sad",
        "panda_03_sad",
        "panda_04_apatic",
        "panda_05_mostly_happy",
        "panda_06_really_haappy",
        "panda_16_in_love"
    };
    private static AvatarManager instance = null;
    private Bitmap[] bitmaps;
    private ImageView avatarView;
    private TextView myScoreView;
    private TextView populationScoreView;
    private float myScore;
    private float populationScore;

    private AvatarManager()
    {}

    public static AvatarManager getInstance()
    {
        if(instance == null)
            instance = new AvatarManager();
        return instance;
    }

    public void initialize(
        Context aCtx,
        ImageView aAvatarView,
        TextView aMyScoreView,
        TextView aPopulationScoreView,
        float aMyInitialScore,
        float aPopulationInitialScore)
    {
        avatarView = aAvatarView;
        myScoreView = aMyScoreView;
        populationScoreView = aPopulationScoreView;

        bitmaps = new Bitmap[FILE_NAMES.length];
        for (int i = 0; i < FILE_NAMES.length; ++i)
            bitmaps[i] = BitmapFactory.decodeResource(aCtx.getResources(), aCtx.getResources().getIdentifier("drawable/" + FILE_NAMES[i], null, aCtx.getPackageName()));

        updateScore(aMyInitialScore, aPopulationInitialScore);
    }

    public void updateScore(final float aMyScore)
    {
        myScore = aMyScore;
        avatarView.setImageBitmap(bitmaps[Math.min(NUM_BITMAPS - 1, (int) Math.floor(aMyScore * NUM_BITMAPS))]);
        myScoreView.setText((int)Math.floor(myScore * 100.0f) + "%");
    }

    public void updateScore(final float aMyScore, final float aPopulationScore)
    {
        updateScore(aMyScore);
        populationScore = aPopulationScore;
        populationScoreView.setText((int)Math.floor(populationScore * 100.0f) + "%");
    }
}
