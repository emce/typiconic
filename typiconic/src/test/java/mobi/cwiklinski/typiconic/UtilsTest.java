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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static mobi.cwiklinski.typiconic.Typiconify.IconValue.*;
import static org.junit.Assert.assertEquals;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class UtilsTest {

    @Test
    public void test_replaceIcons() {
        test("A{ta_anchor}A", "A" + ti_anchor.character + "A");
    }

    @Test
    public void test_replaceIcons_noIcons() {
        test("A A", "A A");
    }

    @Test
    public void test_replaceIcons_manyIcons() {
        test("A{ti_anchor}A{ti_zoom}A", "A" + ti_anchor.character + "A" + ti_zoom.character + "A");
    }

    @Test
    public void test_replaceIcons_withDash() {
        test("A{ti-anchor}A{ti-zoom}A", "A" + ti_anchor.character + "A" + ti_zoom.character + "A");
    }

    @Test
    public void test_replaceIcons_wrong() {
        test("A{ti-beerA{ti-zoom}A", "A{ti-beerA{ti-zoom}A");
    }

    @Test
    public void test_replaceIcons_empty() {
        test("A{}A", "A{}A");
    }

    private void test(String in, String out) {
        assertEquals(out, Utils.replaceIcons(new StringBuilder(in)).toString());
    }

}
