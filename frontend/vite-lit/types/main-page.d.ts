import { TwLitElement } from './common/TwLitElement';
import './component/nav-page';
import './component/content-page';
export declare class MainPage extends TwLitElement {
    docsHint: string;
    count: number;
    render(): import("lit-html").TemplateResult<1>;
}
declare global {
    interface HTMLElementTagNameMap {
        'main-page': MainPage;
    }
}
