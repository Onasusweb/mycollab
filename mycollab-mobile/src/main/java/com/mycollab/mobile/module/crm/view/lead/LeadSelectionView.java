/**
 * This file is part of mycollab-mobile.
 *
 * mycollab-mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-mobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-mobile.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycollab.mobile.module.crm.view.lead;

import com.mycollab.db.arguments.NumberSearchField;
import com.mycollab.db.arguments.SearchField;
import com.mycollab.mobile.ui.AbstractPagedBeanList.RowDisplayHandler;
import com.mycollab.mobile.ui.AbstractSelectionView;
import com.mycollab.module.crm.domain.SimpleLead;
import com.mycollab.module.crm.domain.criteria.LeadSearchCriteria;
import com.mycollab.module.crm.i18n.LeadI18nEnum;
import com.mycollab.vaadin.AppContext;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;

/**
 * @author MyCollab Ltd.
 * @since 4.1
 */
public class LeadSelectionView extends AbstractSelectionView<SimpleLead> {
    private static final long serialVersionUID = 8715554837844950390L;

    private LeadListDisplay itemList;

    private LeadRowDisplayHandler rowHandler = new LeadRowDisplayHandler();

    public LeadSelectionView() {
        super();
        createUI();
        this.setCaption(AppContext.getMessage(LeadI18nEnum.M_VIEW_LEAD_NAME_LOOKUP));
    }

    public void createUI() {
        itemList = new LeadListDisplay();
        itemList.setWidth("100%");
        itemList.setRowDisplayHandler(rowHandler);
        this.setContent(itemList);
    }

    @Override
    public void load() {
        LeadSearchCriteria searchCriteria = new LeadSearchCriteria();
        searchCriteria.setSaccountid(new NumberSearchField(SearchField.AND, AppContext.getAccountId()));
        itemList.search(searchCriteria);
        SimpleLead clearLead = new SimpleLead();
        itemList.getListContainer().addComponentAsFirst(rowHandler.generateRow(clearLead, 0));
    }

    private class LeadRowDisplayHandler implements RowDisplayHandler<SimpleLead> {

        @Override
        public Component generateRow(final SimpleLead lead, int rowIndex) {
            return new Button(lead.getLeadName(), new Button.ClickListener() {
                private static final long serialVersionUID = 9024530145840868279L;

                @Override
                public void buttonClick(final Button.ClickEvent event) {
                    selectionField.fireValueChange(lead);
                    LeadSelectionView.this.getNavigationManager().navigateBack();
                }
            });
        }
    }
}
