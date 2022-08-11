import {
  animate,
  fadeIn,
  fadeOut,
} from '@lit-labs/motion';
import { html } from 'lit';
import {
  customElement,
  property,
} from 'lit/decorators.js';
import { repeat } from 'lit/directives/repeat.js';
import { TwLitElement } from './common/TwLitElement';
import './component/content-page';
import './component/nav-page';
import { getTodosAPI } from './service/todo-service';

@customElement('main-page')
export class MainPage extends TwLitElement {
  @property({ type: Boolean }) profileActive = false;

  private _apiTask = getTodosAPI(this, 50);
  private duration = 500;

  render() {
    return html`
      <div class="min-h-full">
        <nav-page
          .profileActive="${this.profileActive}"
          @focusout="${() => {
            if (this.profileActive) {
              this.profileActive =
                  !this.profileActive; 
            }
          }}"
          @showprofile="${(e: any) => {
            this.profileActive =
              e.detail.profileActive;
          }}"
        ></nav-page>
        <content-page>
          <!-- Replace with your content -->
          <div class="px-2 py-3 sm:px-0">
            ${this._apiTask.render({
              pending: () => html`Loading data...`,
              error: () =>
                html`Loading data failed!!!`,
              complete: (todos: any) =>
                this.onComplete(todos),
            })}
          </div>
          <!-- /End replace -->
        </content-page>
      </div>
    `;
  }

  private onComplete(todos: Array<any>) {
    return html`${repeat(
      todos,
      (i) => i,
      (todo, i) => html`<div
        ${animate({
          keyframeOptions: {
            duration: this.duration,
            delay: (i * this.duration) / todos.length,
            fill: 'both',
          },
          in: fadeIn,
          out: fadeOut,
        })}
        class="mt-3 space-y-4 xl:mt-6"
      >
        <div
          class="flex items-center justify-between max-w-2xl px-8 py-4 mx-auto border border-blue-500 cursor-pointer rounded-xl"
        >
          <div class="flex items-center">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              class="w-5 h-5 ${todo.completed
                ? 'text-blue-600'
                : 'text-gray-400'} sm:h-6 sm:w-6"
              viewBox="0 0 20 20"
              fill="currentColor"
            >
              <path
                fill-rule="evenodd"
                d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z"
                clip-rule="evenodd"
              />
            </svg>

            <div class="flex flex-col mx-5 space-y-1">
              <h2
                class="text-lg font-medium ${todo.completed
                  ? 'text-blue-700'
                  : 'text-gray-300'} sm:text-1xl"
              >
                ${todo.title}
              </h2>
            </div>
          </div>
        </div>
      </div>`
    )}`;
  }
}

declare global {
  interface HTMLElementTagNameMap {
    'main-page': MainPage;
  }
}
