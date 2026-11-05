/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.chats.gemini.network;

public class ModelInfo {
    public String name;
    public String displayName;
    public String description;

    public ModelInfo(String name, String displayName, String description) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
    }
}
