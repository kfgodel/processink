package info.kfgodel.processink.api.events

import info.kfgodel.processink.api.extended.ProcessinkApi

/**
 * This interface groups the mouse events a processink sketch can handle
 * Date: 6/6/20 - 16:57
 */
interface MouseEventHandler {

  /**
   * Called by Processing to handle a mouse clicked event
   * @see [https://processing.org/reference/mouseClicked_.html](https://processing.org/reference/mouseClicked_.html)
   * @param event The mouse event that contains the event data
   * @param api The API to interact with processink
   */
  fun onMouseClicked(event: MouseEvent, api: ProcessinkApi) {
    //Ignore the event. Same as default Processing behavior
  }

  /**
   * Called by Processing to handle a mouse drag event
   * @see [https://processing.org/reference/mouseDragged_.html](https://processing.org/reference/mouseDragged_.html)
   * @param event The mouse event that contains the event data
   * @param api The API to interact with processink
   */
  fun onMouseDragged(event: MouseEvent, api: ProcessinkApi) {
    //Ignore the event. Same as default Processing behavior
  }

  /**
   * Called by Processing to handle a mouse into the sketch window event.<br>
   * No official doc reference
   * @param event The mouse event that contains the event data
   * @param api The API to interact with processink
   */
  fun onMouseEntered(event: MouseEvent, api: ProcessinkApi) {
    //Ignore the event. Same as default Processing behavior
  }

  /**
   * Called by Processing to handle a mouse out of the sketch window event.<br>
   * No official doc reference
   * @param event The mouse event that contains the event data
   * @param api The API to interact with processink
   */
  fun onMouseExited(event: MouseEvent, api: ProcessinkApi) {
    //Ignore the event. Same as default Processing behavior
  }

  /**
   * Called by Processing to handle a mouse move event
   * @see [https://processing.org/reference/mouseMoved_.html](https://processing.org/reference/mouseMoved_.html)
   * @param event The mouse event that contains the event data
   * @param api The API to interact with processink
   */
  fun onMouseMoved(event: MouseEvent, api: ProcessinkApi) {
    //Ignore the event. Same as default Processing behavior
  }

  /**
   * Called by Processing to handle a mouse button press event
   * @see [https://processing.org/reference/mousePressed_.html](https://processing.org/reference/mousePressed_.html)
   * @param event The mouse event that contains the event data
   * @param api The API to interact with processink
   */
  fun onMousePressed(event: MouseEvent, api: ProcessinkApi) {
    //Ignore the event. Same as default Processing behavior
  }

  /**
   * Called by Processing to handle a mouse button release event
   * @see [https://processing.org/reference/mouseReleased_.html](https://processing.org/reference/mouseReleased_.html)
   * @param event The mouse event that contains the event data
   * @param api The API to interact with processink
   */
  fun onMouseReleased(event: MouseEvent, api: ProcessinkApi) {
    //Ignore the event. Same as default Processing behavior
  }

  /**
   * Called by Processing to handle a mouse wheel event
   * @see [https://processing.org/reference/mouseWheel_.html](https://processing.org/reference/mouseWheel_.html)
   * @param event The mouse event that contains the event data
   * @param api The API to interact with processink
   */
  fun onMouseWheel(event: MouseEvent, api: ProcessinkApi) {
    //Ignore the event. Same as default Processing behavior
  }
}