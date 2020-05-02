package info.kfgodel.processink.api

/**
 * This type represents a user defined processing "sketch" visualization.<br>
 * The sketch represents what the user wants Processing to do when it's run.<br>
 * It not only includes visualizations but any of the Processing features (music, sound, camera, etc)
 *
 * Created by kfgodel on 26/10/15.
 */
interface ProcessingSketch {
    /**
     * Called when the sketch is initialized to define viewport configuration
     * and rendering settings
     * @param configuration The configuration that can be changed before starting the actual display
     */
    fun onSettings()

    /**
     * Invoked after the sketch viewport is initialized but before the drawing code is called.
     * This is run only once, allowing to configura application state or draw static things
     * @param processingSetup The setup context available to the sketch
     */
    fun onSetup()

    /**
     * Invoked on every frame after setup has been called to redraw the scene.<br>
     * How frequent this method gets called depends on the fps configuration of the sketch and
     * how much each frame takes to render. If it takes too much the fps goal may not be met.
     *
     * @param givenCanvas The processing pixel space that can be drawn on
     */
    fun onDraw()

    /**
     * Invoked on a mouse click and release event
     * @param mouseEvent The processing context of the mouse event
     */
    fun onMouseClicked()
}