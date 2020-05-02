package info.kfgodel.processink.api

/**
 * This type represents the object that knows how to run sketches with processing. <br>
 * It allows "executing" the processing applications defined as sketches
 * Created by kfgodel on 26/10/15.
 */
interface SketchRunner {
    /**
     * Runs the given sketch to display its contents using Processing.<br<
     * This method is non-blocking and a separate thread will handle the sketch processing, returning inmediately
     * after invocation
     * @param sketch The sketch that will be displayed
     */
    fun run(sketch: ProcessingSketch)
}