package org.teamfarce.mirch.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import org.teamfarce.mirch.Settings;
import org.teamfarce.mirch.Vector2Int;
import org.teamfarce.mirch.map.Room;

/**
 * Base class to represent different map entities.
 */
public class MapEntity extends Sprite implements tileLocation
{
    protected Room room;
    protected String name;
    protected String description;
    protected String filename;

    /**
     * This is the location on the map in terms of tiles can be set using {@link #setTileCoordinates(int, int)}
     * Note: this is different to com.badlogic.gdx.graphics.g2d.Sprite.position that is the position on the screen in terms of pixels,
     * whereas this is in terms of map tiles relative to the bottom left of the map.
     */
    protected Vector2Int tileCoordinates;
    /**
     * Initialise the entity.
     *
     * @param name        The name of the entity.
     * @param description The description of the entity.
     * @param filename    The filename of the image to display for the entity.
     */
    public MapEntity(
            String name,
            String description,
            String filename
    )
    {
        super(new Texture(Gdx.files.internal(filename)));
        this.name = name;
        this.description = description;
        this.filename = filename;
        this.tileCoordinates = new Vector2Int(0,0);
    }

    /**
     * Sets the tile location of the object
     * @param x the x tile
     * @param y the y tile
     */
    @Override
    public void setTileCoordinates(int x, int y) {
        this.tileCoordinates = new Vector2Int(x,y);
        this.setPosition(x * Settings.TILE_SIZE, y * Settings.TILE_SIZE);
    }

    /**
     * Sets the tile location of the object
     * @param vector the vector location to set it to
     */
    @Override
    public void setTileCoordinates(Vector2Int vector) {
        this.tileCoordinates = vector;
        this.setPosition(vector.x * Settings.TILE_SIZE, vector.y * Settings.TILE_SIZE);
    }

    /**
     * Gets the x location of the object in terms of tiles
     * @return x tiles
     */
    @Override
    public int getTileX()
    {
        return tileCoordinates.x;
    }

    /**
     * Gets the y location of the object in terms of tiles
     * @return y tile
     */
    @Override
    public int getTileY()
    {
        return tileCoordinates.y;
    }


    public Vector2Int getTileCoordinates() {
        return this.tileCoordinates;
    }

    /**
     * Gets the current room the entity is within.
     *
     * @return The entity's current room.
     */
    public Room getRoom()
    {
        return this.room;
    }

    /**
     * Set the room of the entity.
     *
     * @param room The room to set.
     */
    public void setRoom(Room room)
    {
        this.room = room;
    }

    /**
     * Get the name of the entity.
     *
     * @return The entity's name.
     */
    public String getName()
    {
        return this.name;
    }

    public String getFilename()  {
        return this.filename;
    }

    /**
     * Get the description.
     *
     * @return The entity's description.
     */
    public String getDescription()
    {
        return this.description;
    }
}