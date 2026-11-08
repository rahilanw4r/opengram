/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.preferences;

import static org.telegram.messenger.LocaleController.getString;

import android.content.Context;
import android.media.MediaRecorder;
import android.view.View;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.R;
import org.telegram.messenger.browser.Browser;
import org.telegram.ui.ActionBar.AlertDialog;
import org.telegram.ui.Components.UItem;
import org.telegram.ui.Components.UniversalAdapter;

import java.util.ArrayList;
import java.util.List;

import uz.unnarsx.cherrygram.core.configs.CherrygramDebugConfig;
import uz.unnarsx.cherrygram.preferences.helpers.SettingsHelper;

public class CallsPreferencesEntry extends BaseCGPreferencesEntry {

    private final int audioSourceRow = 1;
    private final int recordingInfoRow = 2;
    private final int groupCallRecordRow = 3;

    @Override
    protected CharSequence getTitle() {
        return getString(R.string.Calls);
    }

    @Override
    protected String getKey() {
        return "calls_preferences";
    }

    @Override
    protected void fillItems(ArrayList<UItem> items, UniversalAdapter adapter) {
        items.add(UItem.asHeader("Audio Routing & Microphone"));
        items.add(UItem.asButton(audioSourceRow, "Audio Recording Source", getAudioSourceString()));
        items.add(UItem.asShadow(null));

        items.add(UItem.asHeader("Call Recording & Privacy"));
        items.add(SettingsHelper.asTextDetail(
                recordingInfoRow,
                0,
                "Two-Way 1-on-1 Call Recording Status",
                "Restricted by Android OS (Android 9+) and WebRTC E2EE. Tap to view technical explanation."
        ));
        items.add(UItem.asShadow(null));

        items.add(UItem.asHeader("Group Calls & Voice Chats"));
        items.add(SettingsHelper.asTextDetail(
                groupCallRecordRow,
                0,
                "Cloud Voice Chat Recording",
                "Full two-way audio recording is legitimately supported in Group Calls and Channels with transparent participant notification."
        ));
        items.add(UItem.asShadow(null));
    }

    @Override
    protected void onClick(UItem item, View view, int position, float x, float y) {
        if (item.id == audioSourceRow) {
            showAudioSourceSelector(view);
        } else if (item.id == recordingInfoRow) {
            showRecordingTransparencyDialog();
        } else if (item.id == groupCallRecordRow) {
            showGroupRecordingInfoDialog();
        }
    }

    private void showRecordingTransparencyDialog() {
        if (getParentActivity() == null) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle("Call Recording Technical Feasibility");
        builder.setMessage(
                "Why 1-on-1 Call Recording is not supported on standard Android:\n\n" +
                "1. Android OS Privacy Protections: Since Android 9 (Pie) and Android 10 (Q), the operating system permanently restricted VOICE_CALL and downlink audio capture to system-privileged apps. AudioPlaybackCapture strictly prohibits capturing USAGE_VOICE_COMMUNICATION streams.\n\n" +
                "2. WebRTC End-to-End Encryption: Telegram 1-on-1 calls are end-to-end encrypted (SRTP/MTProto) peer-to-peer. Central servers never touch decrypted audio.\n\n" +
                "3. Honest & Transparent UX: Any app claiming client-side call recording on modern non-rooted Android captures only the local microphone, leaving the remote participant silent. Opengram strictly adheres to privacy honesty and will not provide misleading one-sided recordings."
        );
        builder.setPositiveButton(getString(R.string.OK), null);
        builder.show();
    }

    private void showGroupRecordingInfoDialog() {
        if (getParentActivity() == null) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle("Group Call Cloud Recording");
        builder.setMessage(
                "Group Calls and Voice Chats run via Telegram's high-capacity audio servers. In any Group Call where you are an administrator, tap the three dots menu and select 'Start Recording'.\n\n" +
                "All participants receive a visible recording badge, ensuring full privacy transparency and high-fidelity two-way audio saved directly to your Saved Messages."
        );
        builder.setPositiveButton(getString(R.string.OK), null);
        builder.show();
    }

    private String getAudioSourceString() {
        return switch (CherrygramDebugConfig.INSTANCE.getAudioSource()) {
            case MediaRecorder.AudioSource.MIC -> "MIC (Default)";
            case MediaRecorder.AudioSource.VOICE_COMMUNICATION -> "VOICE_COMMUNICATION";
            case MediaRecorder.AudioSource.VOICE_RECOGNITION -> "VOICE_RECOGNITION";
            case MediaRecorder.AudioSource.CAMCORDER -> "CAMCORDER";
            case MediaRecorder.AudioSource.VOICE_CALL -> "VOICE_CALL (Legacy)";
            default -> "DEFAULT";
        };
    }

    private void showAudioSourceSelector(View view) {
        if (getParentActivity() == null) return;

        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        names.add("DEFAULT");
        values.add(MediaRecorder.AudioSource.DEFAULT);

        names.add("MIC (Default)");
        values.add(MediaRecorder.AudioSource.MIC);

        names.add("VOICE_COMMUNICATION");
        values.add(MediaRecorder.AudioSource.VOICE_COMMUNICATION);

        names.add("VOICE_RECOGNITION");
        values.add(MediaRecorder.AudioSource.VOICE_RECOGNITION);

        names.add("CAMCORDER");
        values.add(MediaRecorder.AudioSource.CAMCORDER);

        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle("Audio Recording Source");
        builder.setItems(names.toArray(new CharSequence[0]), (dialog, which) -> {
            CherrygramDebugConfig.INSTANCE.setAudioSource(values.get(which));
            SettingsHelper.updateButtonValue(view, getAudioSourceString());
        });
        builder.show();
    }
}
