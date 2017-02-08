package org.teamfarce.mirch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by brookehatton on 01/02/2017.
 */
public class Assets
{
    /**
     * These variables store the textures for the corresponding arrow directions
     */
    public static TextureRegion UP_ARROW;
    public static TextureRegion DOWN_ARROW;
    public static TextureRegion LEFT_ARROW;
    public static TextureRegion RIGHT_ARROW;

    /**
     * @param file - The file that contains the textures.
     * @return Returns the new texture.
     */
    public static Texture loadTexture(String file)
    {
        return new Texture(Gdx.files.internal(file));
    }

    /**
     * This loads all of the necessary textures
     */
    public static void load()
    {
        Texture arrows = loadTexture("arrows.png");
        LEFT_ARROW = new TextureRegion(arrows, 0, 0, 32, 32);
        RIGHT_ARROW = new TextureRegion(arrows, 32, 0, 32, 32);
        DOWN_ARROW = new TextureRegion(arrows, 0, 32, 32, 32);
        UP_ARROW = new TextureRegion(arrows, 32, 32, 32, 32);
    }

    /**
     * This method takes a direction and returns the corresponding arrow asset for that direction
     *
     * @param direction - The direction to fetch
     * @return (TextureRegion) the corresponding TextureRegion
     */
    public static TextureRegion getArrowDirection(String direction)
    {
        if (direction.equals("NORTH")) {
            return UP_ARROW;
        } else if (direction.equals("SOUTH")) {
            return DOWN_ARROW;
        } else if (direction.equals("WEST")) {
            return LEFT_ARROW;
        } else if (direction.equals("EAST")) {
            return RIGHT_ARROW;
        }

        return null;
    }

}