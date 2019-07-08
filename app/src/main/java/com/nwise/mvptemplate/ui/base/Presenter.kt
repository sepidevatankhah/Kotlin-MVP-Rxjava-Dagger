package com.nwise.mvptemplate.ui.base

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
interface Presenter<V> {

    /**
     * @return Returns true if the view is currently attached to the presenter, otherwise returns false.
     */
    val isViewAttached: Boolean

    /**
     * Called when the view attached to the screen.
     *
     * @param view the view that the presenter interacts with
     */
    fun onViewAttached(view: V)

    /**
     * Called when the view detached from the screen.
     */
    fun onViewDetached()

    /**
     * Called when a user leaves the view completely.
     */
    fun onDestroy()
}
