import { TwLitElement } from '../common/TwLitElement';
export declare class NavPage extends TwLitElement {
    heroActive: boolean;
    render(): import("lit-html").TemplateResult<1>;
}
declare global {
    interface HTMLElementTagNameMap {
        'nav-page': NavPage;
    }
}
