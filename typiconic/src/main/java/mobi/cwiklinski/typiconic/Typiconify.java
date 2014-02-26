/**
 * Copyright 2014 Michał Ćwikliński
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * It uses Typicons font, licensed under CC BY-SA licence, which is compatible
 * with this library's license.
 */
package mobi.cwiklinski.typiconic;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import android.widget.TextView;

import java.io.IOException;

import static android.text.Html.*;
import static mobi.cwiklinski.typiconic.Utils.*;
import static java.lang.String.valueOf;

public final class Typiconify {

    private static final String TTF_FILE = "typicons.ttf";

    public static final String TAG = Typiconify.class.getSimpleName();

    private static Typeface typeface = null;

    private Typiconify() {
        // Singleton
    }

    /** Transform the given TextViews replacing {icon_xxx} texts with icons. */
    public static void addIcons(TextView... textViews) {
        for (TextView textView : textViews) {
            /*textView.setTypeface(getTypeface(textView.getContext()));
            textView.setText(compute(textView.getText()));*/
            parseTextView(textView);
        }
    }

    public static CharSequence compute(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            String text = toHtml((Spanned) charSequence);
            return fromHtml(replaceIcons(new StringBuilder((text))).toString());
        }
        String text = charSequence.toString();
        return replaceIcons(new StringBuilder(text));
    }

    public static final void setIcon(TextView textView, IconValue value) {
        textView.setTypeface(getTypeface(textView.getContext()));
        textView.setText(valueOf(value.character));
    }

    public static void parseTextView(TextView textView) {
        Utils.parseIcons(new StringBuilder(textView.getText().toString()),
            getTypeface(textView.getContext()), textView.getCurrentTextColor());
    }

    /**
     * The typeface that contains Typicons icons.
     * @return the typeface, or null if something goes wrong.
     */
    public static Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromFile(resourceToFile(context, TTF_FILE));
            } catch (IOException e) {
                return null;
            }
        }
        return typeface;
    }

    public static enum IconValue {

        ti_adjust_brightness('\ue000'),
        ti_adjust_contrast('\ue001'),
        ti_anchor_outline('\ue002'),
        ti_anchor('\ue003'),
        ti_archive('\ue004'),
        ti_arrow_back_outline('\ue005'),
        ti_arrow_back('\ue006'),
        ti_arrow_down_outline('\ue007'),
        ti_arrow_down_thick('\ue008'),
        ti_arrow_down('\ue009'),
        ti_arrow_forward_outline('\ue00a'),
        ti_arrow_forward('\ue00b'),
        ti_arrow_left_outline('\ue00c'),
        ti_arrow_left_thick('\ue00d'),
        ti_arrow_left('\ue00e'),
        ti_arrow_loop_outline('\ue00f'),
        ti_arrow_loop('\ue010'),
        ti_arrow_maximise_outline('\ue011'),
        ti_arrow_maximise('\ue012'),
        ti_arrow_minimise_outline('\ue013'),
        ti_arrow_minimise('\ue014'),
        ti_arrow_move_outline('\ue015'),
        ti_arrow_move('\ue016'),
        ti_arrow_repeat_outline('\ue017'),
        ti_arrow_repeat('\ue018'),
        ti_arrow_right_outline('\ue019'),
        ti_arrow_right_thick('\ue01a'),
        ti_arrow_right('\ue01b'),
        ti_arrow_shuffle('\ue01c'),
        ti_arrow_sorted_down('\ue01d'),
        ti_arrow_sorted_up('\ue01e'),
        ti_arrow_sync_outline('\ue01f'),
        ti_arrow_sync('\ue020'),
        ti_arrow_unsorted('\ue021'),
        ti_arrow_up_outline('\ue022'),
        ti_arrow_up_thick('\ue023'),
        ti_arrow_up('\ue024'),
        ti_at('\ue025'),
        ti_attachment_outline('\ue026'),
        ti_attachment('\ue027'),
        ti_backspace_outline('\ue028'),
        ti_backspace('\ue029'),
        ti_battery_charge('\ue02a'),
        ti_battery_full('\ue02b'),
        ti_battery_high('\ue02c'),
        ti_battery_low('\ue02d'),
        ti_battery_mid('\ue02e'),
        ti_beaker('\ue02f'),
        ti_beer('\ue030'),
        ti_bell('\ue031'),
        ti_book('\ue032'),
        ti_bookmark('\ue033'),
        ti_briefcase('\ue034'),
        ti_brush('\ue035'),
        ti_business_card('\ue036'),
        ti_calculator('\ue037'),
        ti_calender_outline('\ue038'),
        ti_calender('\ue039'),
        ti_camera_outline('\ue03a'),
        ti_camera('\ue03b'),
        ti_cancel_outline('\ue03c'),
        ti_cancel('\ue03d'),
        ti_chart_area_outline('\ue03e'),
        ti_chart_area('\ue03f'),
        ti_chart_bar_outline('\ue040'),
        ti_chart_bar('\ue041'),
        ti_chart_line_outline('\ue042'),
        ti_chart_line('\ue043'),
        ti_chart_pie_outline('\ue044'),
        ti_chart_pie('\ue045'),
        ti_chevron_left_outline('\ue046'),
        ti_chevron_left('\ue047'),
        ti_chevron_right_outline('\ue048'),
        ti_chevron_right('\ue049'),
        ti_clipboard('\ue04a'),
        ti_cloud_storage('\ue04b'),
        ti_code_outline('\ue04c'),
        ti_code('\ue04d'),
        ti_coffee('\ue04e'),
        ti_cog_outline('\ue04f'),
        ti_cog('\ue050'),
        ti_compass('\ue051'),
        ti_contacts('\ue052'),
        ti_credit_card('\ue053'),
        ti_cross('\ue054'),
        ti_css3('\ue055'),
        ti_database('\ue056'),
        ti_delete_outline('\ue057'),
        ti_delete('\ue058'),
        ti_device_desktop('\ue059'),
        ti_device_laptop('\ue05a'),
        ti_device_phone('\ue05b'),
        ti_device_tablet('\ue05c'),
        ti_directions('\ue05d'),
        ti_divide_outline('\ue05e'),
        ti_divide('\ue05f'),
        ti_document_add('\ue060'),
        ti_document_delete('\ue061'),
        ti_document_text('\ue062'),
        ti_document('\ue063'),
        ti_download_outline('\ue064'),
        ti_download('\ue065'),
        ti_dropbox('\ue066'),
        ti_edit('\ue067'),
        ti_eject_outline('\ue068'),
        ti_eject('\ue069'),
        ti_equals_outline('\ue06a'),
        ti_equals('\ue06b'),
        ti_export_outline('\ue06c'),
        ti_export('\ue06d'),
        ti_eye_outline('\ue06e'),
        ti_eye('\ue06f'),
        ti_feather('\ue070'),
        ti_film('\ue071'),
        ti_filter('\ue072'),
        ti_flag_outline('\ue073'),
        ti_flag('\ue074'),
        ti_flash_outline('\ue075'),
        ti_flash('\ue076'),
        ti_flow_children('\ue077'),
        ti_flow_merge('\ue078'),
        ti_flow_parallel('\ue079'),
        ti_flow_switch('\ue07a'),
        ti_folder_add('\ue07b'),
        ti_folder_delete('\ue07c'),
        ti_folder_open('\ue07d'),
        ti_folder('\ue07e'),
        ti_gift('\ue07f'),
        ti_globe_outline('\ue080'),
        ti_globe('\ue081'),
        ti_group_outline('\ue082'),
        ti_group('\ue083'),
        ti_headphones('\ue084'),
        ti_heart_full_outline('\ue085'),
        ti_heart_half_outline('\ue086'),
        ti_heart_outline('\ue087'),
        ti_heart('\ue088'),
        ti_home_outline('\ue089'),
        ti_home('\ue08a'),
        ti_html5('\ue08b'),
        ti_image_outline('\ue08c'),
        ti_image('\ue08d'),
        ti_infinity_outline('\ue08e'),
        ti_infinity('\ue08f'),
        ti_info_large_outline('\ue090'),
        ti_info_large('\ue091'),
        ti_info_outline('\ue092'),
        ti_info('\ue093'),
        ti_input_checked_outline('\ue094'),
        ti_input_checked('\ue095'),
        ti_key_outline('\ue096'),
        ti_key('\ue097'),
        ti_keyboard('\ue098'),
        ti_leaf('\ue099'),
        ti_lightbulb('\ue09a'),
        ti_link_outline('\ue09b'),
        ti_link('\ue09c'),
        ti_location_arrow_outline('\ue09d'),
        ti_location_arrow('\ue09e'),
        ti_location_outline('\ue09f'),
        ti_location('\ue0a0'),
        ti_lock_closed_outline('\ue0a1'),
        ti_lock_closed('\ue0a2'),
        ti_lock_open_outline('\ue0a3'),
        ti_lock_open('\ue0a4'),
        ti_mail('\ue0a5'),
        ti_map('\ue0a6'),
        ti_media_eject_outline('\ue0a7'),
        ti_media_eject('\ue0a8'),
        ti_media_fast_forward_outline('\ue0a9'),
        ti_media_fast_forward('\ue0aa'),
        ti_media_pause_outline('\ue0ab'),
        ti_media_pause('\ue0ac'),
        ti_media_play_outline('\ue0ad'),
        ti_media_play_reverse_outline('\ue0ae'),
        ti_media_play_reverse('\ue0af'),
        ti_media_play('\ue0b0'),
        ti_media_record_outline('\ue0b1'),
        ti_media_record('\ue0b2'),
        ti_media_rewind_outline('\ue0b3'),
        ti_media_rewind('\ue0b4'),
        ti_media_stop_outline('\ue0b5'),
        ti_media_stop('\ue0b6'),
        ti_message_typing('\ue0b7'),
        ti_message('\ue0b8'),
        ti_messages('\ue0b9'),
        ti_microphone_outline('\ue0ba'),
        ti_microphone('\ue0bb'),
        ti_minus_outline('\ue0bc'),
        ti_minus('\ue0bd'),
        ti_mortar_board('\ue0be'),
        ti_news('\ue0bf'),
        ti_notes_outline('\ue0c0'),
        ti_notes('\ue0c1'),
        ti_pen('\ue0c2'),
        ti_pencil('\ue0c3'),
        ti_phone_outline('\ue0c4'),
        ti_phone('\ue0c5'),
        ti_pi_outline('\ue0c6'),
        ti_pi('\ue0c7'),
        ti_pin_outline('\ue0c8'),
        ti_pin('\ue0c9'),
        ti_pipette('\ue0ca'),
        ti_plane_outline('\ue0cb'),
        ti_plane('\ue0cc'),
        ti_plug('\ue0cd'),
        ti_plus_outline('\ue0ce'),
        ti_plus('\ue0cf'),
        ti_point_of_interest_outline('\ue0d0'),
        ti_point_of_interest('\ue0d1'),
        ti_power_outline('\ue0d2'),
        ti_power('\ue0d3'),
        ti_printer('\ue0d4'),
        ti_puzzle_outline('\ue0d5'),
        ti_puzzle('\ue0d6'),
        ti_radar_outline('\ue0d7'),
        ti_radar('\ue0d8'),
        ti_refresh_outline('\ue0d9'),
        ti_refresh('\ue0da'),
        ti_rss_outline('\ue0db'),
        ti_rss('\ue0dc'),
        ti_scissors_outline('\ue0dd'),
        ti_scissors('\ue0de'),
        ti_shopping_bag('\ue0df'),
        ti_shopping_cart('\ue0e0'),
        ti_social_at_circular('\ue0e1'),
        ti_social_dribbble_circular('\ue0e2'),
        ti_social_dribbble('\ue0e3'),
        ti_social_facebook_circular('\ue0e4'),
        ti_social_facebook('\ue0e5'),
        ti_social_flickr_circular('\ue0e6'),
        ti_social_flickr('\ue0e7'),
        ti_social_github_circular('\ue0e8'),
        ti_social_github('\ue0e9'),
        ti_social_google_plus_circular('\ue0ea'),
        ti_social_google_plus('\ue0eb'),
        ti_social_instagram_circular('\ue0ec'),
        ti_social_instagram('\ue0ed'),
        ti_social_last_fm_circular('\ue0ee'),
        ti_social_last_fm('\ue0ef'),
        ti_social_linkedin_circular('\ue0f0'),
        ti_social_linkedin('\ue0f1'),
        ti_social_pinterest_circular('\ue0f2'),
        ti_social_pinterest('\ue0f3'),
        ti_social_skype_outline('\ue0f4'),
        ti_social_skype('\ue0f5'),
        ti_social_tumbler_circular('\ue0f6'),
        ti_social_tumbler('\ue0f7'),
        ti_social_twitter_circular('\ue0f8'),
        ti_social_twitter('\ue0f9'),
        ti_social_vimeo_circular('\ue0fa'),
        ti_social_vimeo('\ue0fb'),
        ti_social_youtube_circular('\ue0fc'),
        ti_social_youtube('\ue0fd'),
        ti_sort_alphabetically_outline('\ue0fe'),
        ti_sort_alphabetically('\ue0ff'),
        ti_sort_numerically_outline('\ue100'),
        ti_sort_numerically('\ue101'),
        ti_spanner_outline('\ue102'),
        ti_spanner('\ue103'),
        ti_spiral('\ue104'),
        ti_star_full_outline('\ue105'),
        ti_star_half_outline('\ue106'),
        ti_star_half('\ue107'),
        ti_star_outline('\ue108'),
        ti_star('\ue109'),
        ti_starburst_outline('\ue10a'),
        ti_starburst('\ue10b'),
        ti_stopwatch('\ue10c'),
        ti_support('\ue10d'),
        ti_tabs_outline('\ue10e'),
        ti_tag('\ue10f'),
        ti_tags('\ue110'),
        ti_th_large_outline('\ue111'),
        ti_th_large('\ue112'),
        ti_th_list_outline('\ue113'),
        ti_th_list('\ue114'),
        ti_th_menu_outline('\ue115'),
        ti_th_menu('\ue116'),
        ti_th_small_outline('\ue117'),
        ti_th_small('\ue118'),
        ti_thermometer('\ue119'),
        ti_thumbs_down('\ue11a'),
        ti_thumbs_ok('\ue11b'),
        ti_thumbs_up('\ue11c'),
        ti_tick_outline('\ue11d'),
        ti_tick('\ue11e'),
        ti_ticket('\ue11f'),
        ti_time('\ue120'),
        ti_times_outline('\ue121'),
        ti_times('\ue122'),
        ti_trash('\ue123'),
        ti_tree('\ue124'),
        ti_upload_outline('\ue125'),
        ti_upload('\ue126'),
        ti_user_add_outline('\ue127'),
        ti_user_add('\ue128'),
        ti_user_delete_outline('\ue129'),
        ti_user_delete('\ue12a'),
        ti_user_outline('\ue12b'),
        ti_user('\ue12c'),
        ti_vendor_android('\ue12d'),
        ti_vendor_apple('\ue12e'),
        ti_vendor_microsoft('\ue12f'),
        ti_video_outline('\ue130'),
        ti_video('\ue131'),
        ti_volume_down('\ue132'),
        ti_volume_mute('\ue133'),
        ti_volume_up('\ue134'),
        ti_volume('\ue135'),
        ti_warning_outline('\ue136'),
        ti_warning('\ue137'),
        ti_watch('\ue138'),
        ti_waves_outline('\ue139'),
        ti_waves('\ue13a'),
        ti_weather_cloudy('\ue13b'),
        ti_weather_downpour('\ue13c'),
        ti_weather_night('\ue13d'),
        ti_weather_partly_sunny('\ue13e'),
        ti_weather_shower('\ue13f'),
        ti_weather_snow('\ue140'),
        ti_weather_stormy('\ue141'),
        ti_weather_sunny('\ue142'),
        ti_weather_windy_cloudy('\ue143'),
        ti_weather_windy('\ue144'),
        ti_wi_fi_outline('\ue145'),
        ti_wi_fi('\ue146'),
        ti_wine('\ue147'),
        ti_world_outline('\ue148'),
        ti_world('\ue149'),
        ti_zoom_in_outline('\ue14a'),
        ti_zoom_in('\ue14b'),
        ti_zoom_out_outline('\ue14c'),
        ti_zoom_out('\ue14d'),
        ti_zoom_outline('\ue14e'),
        ti_zoom('\ue14f');

        char character;

        IconValue(char character) {
            this.character = character;
        }

        public String formattedName() {
            return "{" + name() + "}";
        }

        public char character() {
            return character;
        }
    }
}
