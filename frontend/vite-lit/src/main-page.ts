import { html } from 'lit';
import {
  customElement,
  property,
} from 'lit/decorators.js';
import { TwLitElement } from './common/TwLitElement';
import './component/nav-page';
import './component/content-page';

@customElement('main-page')
export class MainPage extends TwLitElement {
  @property()
  docsHint = 'Lorem ipsum dolor';

  @property({ type: Number })
  count = 0;

  render() {
    return html`
      <div class="min-h-full">
        <nav-page></nav-page>
        <content-page>
          <!-- Replace with your content -->
          <div class="px-4 py-6 sm:px-0">
            <div
              class="border-4 border-dashed border-gray-200 rounded-lg h-96"
            ></div>
          </div>
          <!-- /End replace -->
        </content-page>
      </div>
    `;
  }
}

declare global {
  interface HTMLElementTagNameMap {
    'main-page': MainPage;
  }
}
