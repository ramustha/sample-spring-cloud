import { html } from 'lit';
import {
  customElement
} from 'lit/decorators.js';
import { TwLitElement } from '../common/TwLitElement';

@customElement('content-page')
export class ContentPage extends TwLitElement {
  render() {
    return html`
      <header class="bg-white shadow">
        <div
          class="max-w-7xl mx-auto py-6 px-4 sm:px-6 lg:px-8"
        >
          <h1 class="text-3xl font-bold text-gray-900">
            Dashboard
          </h1>
        </div>
      </header>
      <main>
        <div
          class="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8"
        >
          <slot></slot>
        </div>
      </main>
    `;
  }
}
declare global {
  interface HTMLElementTagNameMap {
    'content-page': ContentPage;
  }
}
