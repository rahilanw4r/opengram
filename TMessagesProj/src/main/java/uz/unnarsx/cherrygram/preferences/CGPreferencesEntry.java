/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.preferences;

import static org.telegram.messenger.AndroidUtilities.dp;
import static org.telegram.messenger.LocaleController.getString;

import static uz.unnarsx.cherrygram.preferences.helpers.SettingsHelper.applyNewSpan;
import static uz.unnarsx.cherrygram.preferences.helpers.SettingsHelper.applyProSpan;

import android.content.Context;
import android.view.View;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.R;
import org.telegram.messenger.browser.Browser;
import org.telegram.ui.ActionBar.ActionBarMenu;
import org.telegram.ui.ActionBar.ActionBarMenuItem;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Components.Bulletin;
import org.telegram.ui.Components.BulletinFactory;
import org.telegram.ui.Components.IconBackgroundColors;
import org.telegram.ui.Components.ItemOptions;
import org.telegram.ui.Components.UItem;
import org.telegram.ui.Components.UniversalAdapter;
import org.telegram.ui.SettingsActivity;

import java.util.ArrayList;

import kotlin.Pair;
import uz.unnarsx.cherrygram.chats.CGChatMenuInjector;
import uz.unnarsx.cherrygram.core.configs.CherrygramExperimentalConfig;
import uz.unnarsx.cherrygram.core.configs.CherrygramFirebaseConfig;
import uz.unnarsx.cherrygram.core.firebase.crashlytics.Crashlytics;
import uz.unnarsx.cherrygram.core.firebase.FirebaseAnalyticsHelper;
import uz.unnarsx.cherrygram.core.helpers.AppRestartHelper;
import uz.unnarsx.cherrygram.core.helpers.DeeplinkHelper;
import uz.unnarsx.cherrygram.core.configs.backup.BackupHelper;
import uz.unnarsx.cherrygram.preferences.helpers.TelegramSettingsHelper;

public class CGPreferencesEntry extends BaseCGPreferencesEntry {

    private final int appearanceRow = 1;
    private final int chatsRow = 2;
    private final int messagesRow = 3;
    private final int mediaRow = 4;
    private final int notificationsRow = 5;
    private final int privacyRow = 6;
    private final int callsRow = 7;
    private final int advancedRow = 8;

    @Override
    protected CharSequence getTitle() {
        FirebaseAnalyticsHelper.INSTANCE.trackEventWithEmptyBundle("main_preferences_screen");
        return getString(R.string.CGP_AdvancedSettings);
    }

    @Override
    protected String getKey() {
        return DeeplinkHelper.DeepLinksRepo.CG_Settings;
    }

    @Override
    public View createView(Context context) {
        final ActionBarMenu menu = actionBar.createMenu();
        ActionBarMenuItem otherItem = menu.addItem(1, R.drawable.ic_ab_other);
        otherItem.setOnClickListener(view -> showItemOptions(otherItem));

        return super.createView(context);
    }

    @Override
    protected void fillItems(ArrayList<UItem> items, UniversalAdapter adapter) {
        items.add(UItem.asHeader(getString(R.string.Settings)));

        // 1. Appearance
        Pair<Integer, Integer> colors = TelegramSettingsHelper.Helper.INSTANCE.getProfileButtonColor(getUserConfig().getCurrentUser(), true);
        items.add(
                SettingsActivity.SettingCell.Factory.of(
                        appearanceRow,
                        Theme.isCurrentThemeDay() ? colors.getSecond() : colors.getFirst(),
                        Theme.isCurrentThemeDay() ? colors.getFirst() : colors.getSecond(),
                        R.drawable.settings_palette_filled_solar,
                        getString(R.string.AP_Header_Appearance),
                        getString(R.string.CGP_Appearance_Desc),
                        true
                )
                .slug(DeeplinkHelper.DeepLinksRepo.CG_Appearance)
        );

        // 2. Chats
        items.add(
                SettingsActivity.SettingCell.Factory.of(
                        chatsRow, IconBackgroundColors.ORANGE.top, IconBackgroundColors.ORANGE.bottom,
                        R.drawable.settings_chats_filled_solar,
                        getString(R.string.FilterChats),
                        getString(R.string.CGP_Chats_Desc),
                        true
                )
                .slug(DeeplinkHelper.DeepLinksRepo.CG_Chats)
        );

        // 3. Messages
        items.add(
                SettingsActivity.SettingCell.Factory.of(
                        messagesRow,
                        IconBackgroundColors.GREEN.top, IconBackgroundColors.GREEN.bottom,
                        R.drawable.settings_filled_solar,
                        getString(R.string.MessagesSettings),
                        "Message menu, send confirmation, actions & filters",
                        true
                )
                .slug(DeeplinkHelper.DeepLinksRepo.CG_Messages)
        );

        // 4. Media
        items.add(
                SettingsActivity.SettingCell.Factory.of(
                        mediaRow,
                        0xFF0288D1, 0xFF01579B,
                        R.drawable.settings_camera_filled_solar,
                        getString(R.string.CP_Category_Camera),
                        getString(R.string.CGP_Camera_Desc),
                        true
                )
                .slug(DeeplinkHelper.DeepLinksRepo.CG_Camera)
        );

        // 5. Notifications
        items.add(
                SettingsActivity.SettingCell.Factory.of(
                        notificationsRow,
                        IconBackgroundColors.RED.top, IconBackgroundColors.RED.bottom,
                        R.drawable.settings_sounds,
                        getString(R.string.Notifications),
                        "Mute non-contacts, mentions & background service",
                        true
                )
                .slug(DeeplinkHelper.DeepLinksRepo.CG_General)
        );

        // 6. Privacy & Security
        items.add(
                SettingsActivity.SettingCell.Factory.of(
                        privacyRow,
                        IconBackgroundColors.CYAN.top, IconBackgroundColors.CYAN.bottom,
                        R.drawable.settings_privacy_solar_filled,
                        getString(R.string.SettingsPrivacySecurity),
                        getString(R.string.CGP_Privacy_Desc),
                        true
                )
                .slug(DeeplinkHelper.DeepLinksRepo.CG_Privacy)
        );

        // 7. Calls
        items.add(
                SettingsActivity.SettingCell.Factory.of(
                        callsRow,
                        IconBackgroundColors.GREEN.top, IconBackgroundColors.GREEN.bottom,
                        R.drawable.settings_calls,
                        getString(R.string.Calls),
                        "Audio source routing & call recording transparency",
                        true
                )
                .slug("cg_calls")
        );

        // 8. Advanced & About
        items.add(
                SettingsActivity.SettingCell.Factory.of(
                        advancedRow,
                        IconBackgroundColors.PURPLE.top, IconBackgroundColors.PURPLE.bottom,
                        R.drawable.settings_info_filled_solar,
                        "Advanced & About",
                        getString(R.string.CGP_Header_About_Desc),
                        true
                )
                .slug(DeeplinkHelper.DeepLinksRepo.CG_About)
        );

        items.add(UItem.asShadow(null));
    }

    @Override
    protected void onClick(UItem item, View view, int position, float x, float y) {
        if (item.id == appearanceRow) {
            CherrygramPreferencesNavigator.INSTANCE.createAppearance(this);
        } else if (item.id == chatsRow) {
            CherrygramPreferencesNavigator.INSTANCE.createChats(this);
        } else if (item.id == messagesRow) {
            CherrygramPreferencesNavigator.INSTANCE.createMessages(this);
        } else if (item.id == mediaRow) {
            CherrygramPreferencesNavigator.INSTANCE.createCamera(this);
        } else if (item.id == notificationsRow) {
            CherrygramPreferencesNavigator.INSTANCE.createGeneral(this);
        } else if (item.id == privacyRow) {
            CherrygramPreferencesNavigator.INSTANCE.createPrivacy(this);
        } else if (item.id == callsRow) {
            CherrygramPreferencesNavigator.INSTANCE.createCalls(this);
        } else if (item.id == advancedRow) {
            CherrygramPreferencesNavigator.INSTANCE.createAbout(this);
        }
    }

    private void showItemOptions(View button) {
        ItemOptions o = ItemOptions.makeOptions(this, button);

        o.add(R.drawable.msg_shareout_solar, getString(R.string.CG_ExportSettings), () -> BackupHelper.INSTANCE.backupSettings(this));
        o.add(R.drawable.msg_photo_settings_solar, getString(R.string.CG_ImportSettings), () -> BackupHelper.INSTANCE.importSettings(this));
        o.addGap();
        o.add(R.drawable.msg_reset_solar, getString(R.string.CG_ResetSettings), true, () -> BackupHelper.INSTANCE.resetSettings(this));
        o.addSpaceGap();

        o.add(R.drawable.bug_solar, getString(R.string.CG_CopyReportDetails), () -> {
            AndroidUtilities.addToClipboard(Crashlytics.getReportMessage() + "\n\n#bug");
            BulletinFactory.of(this).createErrorBulletin(getString(R.string.CG_ReportDetailsCopied))
                    .setDuration(Bulletin.DURATION_SHORT)
                    .show();
        });
        o.addGap();
        o.add(R.drawable.msg_retry_solar, getString(R.string.CG_Restart), () -> AppRestartHelper.restartApp(getContext()));

        o.setBlur(false);
        o.setDrawScrim(false);
        o.translate(0F, -dp(48F));
        o.show();
    }

}
