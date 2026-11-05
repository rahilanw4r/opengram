/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.core.icons.icon_replaces

abstract class BaseIconReplace {
    abstract val replaces: HashMap<Int, Int>

    fun wrap(id: Int): Int {
        return replaces[id] ?: id
    }

}