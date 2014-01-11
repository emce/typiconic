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
    public static final void addIcons(TextView... textViews) {
        for (TextView textView : textViews) {
            textView.setTypeface(getTypeface(textView.getContext()));
            textView.setText(compute(textView.getText()));
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

    /**
     * The typeface that contains Typicons icons.
     * @return the typeface, or null if something goes wrong.
     */
    public static final Typeface getTypeface(Context context) {
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
        ti_arrow_sync_outline('\ue01d'),
        ti_arrow_sync('\ue01e'),
        ti_arrow_up_outline('\ue01f'),
        ti_arrow_up_thick('\ue020'),
        ti_arrow_up('\ue021'),
        ti_at('\ue022'),
        ti_attachment_outline('\ue023'),
        ti_attachment('\ue024'),
        ti_backspace_outline('\ue025'),
        ti_backspace('\ue026'),
        ti_battery_charge('\ue027'),
        ti_battery_full('\ue028'),
        ti_battery_high('\ue029'),
        ti_battery_low('\ue02a'),
        ti_battery_mid('\ue02b'),
        ti_beaker('\ue02c'),
        ti_beer('\ue02d'),
        ti_bell('\ue02e'),
        ti_book('\ue02f'),
        ti_bookmark('\ue030'),
        ti_briefcase('\ue031'),
        ti_brush('\ue032'),
        ti_business_card('\ue033'),
        ti_calculator('\ue034'),
        ti_calender_outline('\ue035'),
        ti_calender('\ue036'),
        ti_camera_outline('\ue037'),
        ti_camera('\ue038'),
        ti_cancel_outline('\ue039'),
        ti_cancel('\ue03a'),
        ti_chart_area_outline('\ue03b'),
        ti_chart_area('\ue03c'),
        ti_chart_bar_outline('\ue03d'),
        ti_chart_bar('\ue03e'),
        ti_chart_line_outline('\ue03f'),
        ti_chart_line('\ue040'),
        ti_chart_pie_outline('\ue041'),
        ti_chart_pie('\ue042'),
        ti_chevron_left_outline('\ue043'),
        ti_chevron_left('\ue044'),
        ti_chevron_right_outline('\ue045'),
        ti_chevron_right('\ue046'),
        ti_clipboard('\ue047'),
        ti_cloud_storage('\ue048'),
        ti_code_outline('\ue049'),
        ti_code('\ue04a'),
        ti_coffee('\ue04b'),
        ti_cog_outline('\ue04c'),
        ti_cog('\ue04d'),
        ti_compass('\ue04e'),
        ti_contacts('\ue04f'),
        ti_credit_card('\ue050'),
        ti_cross('\ue051'),
        ti_database('\ue052'),
        ti_delete_outline('\ue053'),
        ti_delete('\ue054'),
        ti_device_desktop('\ue055'),
        ti_device_laptop('\ue056'),
        ti_device_phone('\ue057'),
        ti_device_tablet('\ue058'),
        ti_directions('\ue059'),
        ti_divide_outline('\ue05a'),
        ti_divide('\ue05b'),
        ti_document_add('\ue05c'),
        ti_document_delete('\ue05d'),
        ti_document_text('\ue05e'),
        ti_document('\ue05f'),
        ti_download_outline('\ue060'),
        ti_download('\ue061'),
        ti_edit('\ue062'),
        ti_eject_outline('\ue063'),
        ti_eject('\ue064'),
        ti_equals_outline('\ue065'),
        ti_equals('\ue066'),
        ti_export_outline('\ue067'),
        ti_export('\ue068'),
        ti_eye_outline('\ue069'),
        ti_eye('\ue06a'),
        ti_feather('\ue06b'),
        ti_film('\ue06c'),
        ti_flag_outline('\ue06d'),
        ti_flag('\ue06e'),
        ti_flash_outline('\ue06f'),
        ti_flash('\ue070'),
        ti_flow_children('\ue071'),
        ti_flow_merge('\ue072'),
        ti_flow_parallel('\ue073'),
        ti_flow_switch('\ue074'),
        ti_folder_add('\ue075'),
        ti_folder_delete('\ue076'),
        ti_folder('\ue077'),
        ti_gift('\ue078'),
        ti_globe_outline('\ue079'),
        ti_globe('\ue07a'),
        ti_group_outline('\ue07b'),
        ti_group('\ue07c'),
        ti_headphones('\ue07d'),
        ti_heart_outline('\ue07e'),
        ti_heart('\ue07f'),
        ti_home_outline('\ue080'),
        ti_home('\ue081'),
        ti_image_outline('\ue082'),
        ti_image('\ue083'),
        ti_infinity_outline('\ue084'),
        ti_infinity('\ue085'),
        ti_info_large_outline('\ue086'),
        ti_info_large('\ue087'),
        ti_info_outline('\ue088'),
        ti_info('\ue089'),
        ti_input_checked_outline('\ue08a'),
        ti_input_checked('\ue08b'),
        ti_key_outline('\ue08c'),
        ti_key('\ue08d'),
        ti_leaf('\ue08e'),
        ti_lightbulb('\ue08f'),
        ti_link_outline('\ue090'),
        ti_link('\ue091'),
        ti_location_arrow_outline('\ue092'),
        ti_location_arrow('\ue093'),
        ti_location_outline('\ue094'),
        ti_location('\ue095'),
        ti_lock_closed_outline('\ue096'),
        ti_lock_closed('\ue097'),
        ti_lock_open_outline('\ue098'),
        ti_lock_open('\ue099'),
        ti_mail('\ue09a'),
        ti_map('\ue09b'),
        ti_media_eject_outline('\ue09c'),
        ti_media_eject('\ue09d'),
        ti_media_fast_forward_outline('\ue09e'),
        ti_media_fast_forward('\ue09f'),
        ti_media_pause_outline('\ue0a0'),
        ti_media_pause('\ue0a1'),
        ti_media_play_outline('\ue0a2'),
        ti_media_play('\ue0a3'),
        ti_media_record_outline('\ue0a4'),
        ti_media_record('\ue0a5'),
        ti_media_rewind_outline('\ue0a6'),
        ti_media_rewind('\ue0a7'),
        ti_media_stop_outline('\ue0a8'),
        ti_media_stop('\ue0a9'),
        ti_message_typing('\ue0aa'),
        ti_message('\ue0ab'),
        ti_messages('\ue0ac'),
        ti_microphone_outline('\ue0ad'),
        ti_microphone('\ue0ae'),
        ti_minus_outline('\ue0af'),
        ti_minus('\ue0b0'),
        ti_news('\ue0b1'),
        ti_notes_outline('\ue0b2'),
        ti_notes('\ue0b3'),
        ti_pen('\ue0b4'),
        ti_pencil('\ue0b5'),
        ti_phone_outline('\ue0b6'),
        ti_phone('\ue0b7'),
        ti_pi_outline('\ue0b8'),
        ti_pi('\ue0b9'),
        ti_pin_outline('\ue0ba'),
        ti_pin('\ue0bb'),
        ti_pipette('\ue0bc'),
        ti_plane_outline('\ue0bd'),
        ti_plane('\ue0be'),
        ti_plug('\ue0bf'),
        ti_plus_outline('\ue0c0'),
        ti_plus('\ue0c1'),
        ti_point_of_interest_outline('\ue0c2'),
        ti_point_of_interest('\ue0c3'),
        ti_power_outline('\ue0c4'),
        ti_power('\ue0c5'),
        ti_printer('\ue0c6'),
        ti_puzzle_outline('\ue0c7'),
        ti_puzzle('\ue0c8'),
        ti_radar_outline('\ue0c9'),
        ti_radar('\ue0ca'),
        ti_refresh_outline('\ue0cb'),
        ti_refresh('\ue0cc'),
        ti_rss_outline('\ue0cd'),
        ti_rss('\ue0ce'),
        ti_scissors_outline('\ue0cf'),
        ti_scissors('\ue0d0'),
        ti_shopping_bag('\ue0d1'),
        ti_shopping_cart('\ue0d2'),
        ti_social_at_circular('\ue0d3'),
        ti_social_dribbble_circular('\ue0d4'),
        ti_social_dribbble('\ue0d5'),
        ti_social_facebook_circular('\ue0d6'),
        ti_social_facebook('\ue0d7'),
        ti_social_flickr_circular('\ue0d8'),
        ti_social_flickr('\ue0d9'),
        ti_social_github_circular('\ue0da'),
        ti_social_github('\ue0db'),
        ti_social_last_fm_circular('\ue0dc'),
        ti_social_last_fm('\ue0dd'),
        ti_social_linkedin_circular('\ue0de'),
        ti_social_linkedin('\ue0df'),
        ti_social_pinterest_circular('\ue0e0'),
        ti_social_pinterest('\ue0e1'),
        ti_social_skype_outline('\ue0e2'),
        ti_social_skype('\ue0e3'),
        ti_social_tumbler_circular('\ue0e4'),
        ti_social_tumbler('\ue0e5'),
        ti_social_twitter_circular('\ue0e6'),
        ti_social_twitter('\ue0e7'),
        ti_social_vimeo_circular('\ue0e8'),
        ti_social_vimeo('\ue0e9'),
        ti_sort_alphabetically_outline('\ue0ea'),
        ti_sort_alphabetically('\ue0eb'),
        ti_sort_numerically_outline('\ue0ec'),
        ti_sort_numerically('\ue0ed'),
        ti_spanner_outline('\ue0ee'),
        ti_spanner('\ue0ef'),
        ti_star_outline('\ue0f0'),
        ti_star('\ue0f1'),
        ti_starburst_outline('\ue0f2'),
        ti_starburst('\ue0f3'),
        ti_stopwatch('\ue0f4'),
        ti_support('\ue0f5'),
        ti_tabs_outline('\ue0f6'),
        ti_tag('\ue0f7'),
        ti_tags('\ue0f8'),
        ti_th_large_outline('\ue0f9'),
        ti_th_large('\ue0fa'),
        ti_th_list_outline('\ue0fb'),
        ti_th_list('\ue0fc'),
        ti_th_menu_outline('\ue0fd'),
        ti_th_menu('\ue0fe'),
        ti_th_small_outline('\ue0ff'),
        ti_th_small('\ue100'),
        ti_thermometer('\ue101'),
        ti_thumbs_down('\ue102'),
        ti_thumbs_up('\ue103'),
        ti_tick_outline('\ue104'),
        ti_tick('\ue105'),
        ti_ticket('\ue106'),
        ti_time('\ue107'),
        ti_times_outline('\ue108'),
        ti_times('\ue109'),
        ti_trash('\ue10a'),
        ti_tree('\ue10b'),
        ti_upload_outline('\ue10c'),
        ti_upload('\ue10d'),
        ti_user_add_outline('\ue10e'),
        ti_user_add('\ue10f'),
        ti_user_delete_outline('\ue110'),
        ti_user_delete('\ue111'),
        ti_user_outline('\ue112'),
        ti_user('\ue113'),
        ti_video_outline('\ue114'),
        ti_video('\ue115'),
        ti_volume_down('\ue116'),
        ti_volume_mute('\ue117'),
        ti_volume_up('\ue118'),
        ti_volume('\ue119'),
        ti_warning_outline('\ue11a'),
        ti_warning('\ue11b'),
        ti_watch('\ue11c'),
        ti_waves_outline('\ue11d'),
        ti_waves('\ue11e'),
        ti_weather_cloudy('\ue11f'),
        ti_weather_downpour('\ue120'),
        ti_weather_night('\ue121'),
        ti_weather_partly_sunny('\ue122'),
        ti_weather_shower('\ue123'),
        ti_weather_snow('\ue124'),
        ti_weather_stormy('\ue125'),
        ti_weather_sunny('\ue126'),
        ti_weather_windy_cloudy('\ue127'),
        ti_weather_windy('\ue128'),
        ti_wi_fi_outline('\ue129'),
        ti_wi_fi('\ue12a'),
        ti_wine('\ue12b'),
        ti_world_outline('\ue12c'),
        ti_world('\ue12d'),
        ti_zoom_in_outline('\ue12e'),
        ti_zoom_in('\ue12f'),
        ti_zoom_out_outline('\ue130'),
        ti_zoom_out('\ue131'),
        ti_zoom_outline('\ue132'),
        ti_zoom('\ue133');

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
