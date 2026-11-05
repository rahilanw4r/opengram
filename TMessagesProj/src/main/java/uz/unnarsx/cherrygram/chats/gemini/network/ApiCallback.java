/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.chats.gemini.network;

import java.util.List;

public interface ApiCallback {
    void onResult(List<ModelInfo> models);
}
