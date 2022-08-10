import { TwLitElement } from './common/TwLitElement';
import './component/content-page';
import './component/nav-page';
export declare class MainPage extends TwLitElement {
    profileActive: boolean;
    private _apiTask;
    private duration;
    render(): import("lit-html").TemplateResult<1>;
    private onComplete;
}
declare global {
    interface HTMLElementTagNameMap {
        'main-page': MainPage;
    }
}
